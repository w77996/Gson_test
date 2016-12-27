package wu.pra.myapplication.wu.pra.utils;

import android.util.Log;

import com.show.api.ShowApiRequest;

import org.json.JSONException;
import org.json.JSONObject;

import wu.pra.myapplication.wu.pra.bean.AqiDetailBean;
import wu.pra.myapplication.wu.pra.bean.CityInfoBean;
import wu.pra.myapplication.wu.pra.bean.IndexBean;
import wu.pra.myapplication.wu.pra.bean.NowWeatherBean;
import wu.pra.myapplication.wu.pra.bean.TodayWeatherBean;
import wu.pra.myapplication.wu.pra.bean.WeatherBean;

/**
 * Created by Administrator on 2016/12/2.
 *
 *
 *  new Thread(){
 //在新线程中发送网络请求
 public void run() {
 String appid="xxx";//要替换成自己的
 String secret="xxxxxxx";//要替换成自己的
 final String res=new ShowApiRequest("http://route.showapi.com/6-1",appid,secret)
 .addTextPara("num","189123456789")
 .post();
 System.out.println(res);
 //把返回内容通过handler对象更新到界面
 mHandler.post(new Thread(){
 public void run() {
 txt.setText(res+"  "+new Date());
 }
 });
 }
 }.start();
 */
public class HttpUtils {
    public static String JsonData = "";
    public final static String appid = "28198";//要替换成自己的
    public final static String secret = "bd9ad7a172ee4a5a8c57618a248c63e9";//要替换成自己的
    static NowWeatherBean nowWeatherBean;
    static WeatherBean mWeatherBean = new WeatherBean();
    public HttpUtils(){

    }
    public static void getJsonData(final String cityName) {

        new Thread() {
            //在新线程中发送网络请求
            public void run() {

                String res = new ShowApiRequest("http://route.showapi.com/9-2", appid, secret)
                        .addTextPara("areaid", "")
                        .addTextPara("area", cityName)
                        .addTextPara("needMoreDay", "1")
                        .addTextPara("needIndex", "1")
                        .addTextPara("needHourData", "1")
                        .addTextPara("need3HourForcast", "1")
                        .addTextPara("needAlarm", "1")
                        .post();
                System.out.println(res);
                parseJsonData(res);
                //把返回内容通过handler对象更新到界面

            }
        }.start();

    }
    public static void parseJsonData(String jsonData){
        try {
            Log.d("test",jsonData);
            JSONObject resultData = new JSONObject(jsonData);
            JSONObject showapi_res_body = resultData.getJSONObject("showapi_res_body");
            JSONObject nowData = showapi_res_body.getJSONObject("now");
            JSONObject cityInfo = showapi_res_body.getJSONObject("cityInfo");
            JSONObject todayWeatherInfo =  showapi_res_body.getJSONObject("f1");
            parseNowJsonData(nowData);
            parseCityInfo(cityInfo);
            parseTodayWeatherInfo(todayWeatherInfo);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void parseTodayWeatherInfo(JSONObject todayWeatherInfo) {
        TodayWeatherBean todayWeatherBean = new TodayWeatherBean();
        IndexBean indexBean = new IndexBean();

        try {
            todayWeatherBean.mDay_Weather = todayWeatherInfo.getString("day_weather");
            todayWeatherBean.mNight_Weather = todayWeatherInfo.getString("night_weather");
            todayWeatherBean.mNight_Weather_Code = todayWeatherInfo.getString("night_weather_code");
            todayWeatherBean.mAir_Press = todayWeatherInfo.getString("air_press");
            todayWeatherBean.mJiangShui = todayWeatherInfo.getString("jiangshui");
            todayWeatherBean.mNight_Wind_Power =todayWeatherInfo.getString("night_wind_power");
            todayWeatherBean.mDay_Wind_Power = todayWeatherInfo.getString("day_wind_power");
            todayWeatherBean.mDay_Weather_Code = todayWeatherInfo.getString("day_weather_code");
            todayWeatherBean.mSun_Begin = todayWeatherInfo.getString("sun_begin_end");
            todayWeatherBean.mSun_End = todayWeatherInfo.getString("sun_begin_end");
            todayWeatherBean.mZiWaiXian = todayWeatherInfo.getString("ziwaixian");
            todayWeatherBean.mWeekDay = todayWeatherInfo.getString("weekday");
            todayWeatherBean.mNight_Air_Temperature = todayWeatherInfo.getString("night_air_temperature");
            todayWeatherBean.mDay_Air_Temperature = todayWeatherInfo.getString("day_air_temperature");
            todayWeatherBean.mDay_Wind_Direction = todayWeatherInfo.getString("day_wind_direction");
            todayWeatherBean.mDay = todayWeatherInfo.getString("day");
            todayWeatherBean.mNight_Wind_Direction = todayWeatherInfo.getString("night_wind_direction");

            JSONObject indexJsonData = todayWeatherInfo.getJSONObject("index");
            indexBean.mYhTitle = indexJsonData.getJSONObject("yh").getString("title");
            indexBean.mYhDesc = indexJsonData.getJSONObject("yh").getString("desc");
            indexBean.mLsTitle = indexJsonData.getJSONObject("ls").getString("title");
            indexBean.mLsDesc = indexJsonData.getJSONObject("ls").getString("desc");
            indexBean.mClothesTitle = indexJsonData.getJSONObject("clothes").getString("title");
            indexBean.mClothesDesc = indexJsonData.getJSONObject("clothes").getString("desc");
            indexBean.mDyTitle = indexJsonData.getJSONObject("dy").getString("title");
            indexBean.mDyDesc = indexJsonData.getJSONObject("dy").getString("desc");
            indexBean.mSportsTitle = indexJsonData.getJSONObject("sports").getString("title");
            indexBean.mSportsDesc = indexJsonData.getJSONObject("sports").getString("desc");
            indexBean.mTravelTitle = indexJsonData.getJSONObject("travel").getString("title");
            indexBean.mTravelDesc = indexJsonData.getJSONObject("travel").getString("desc");
            indexBean.mBeautyTitle = indexJsonData.getJSONObject("beauty").getString("title");
            indexBean.mBeautyDesc = indexJsonData.getJSONObject("beauty").getString("desc");
            indexBean.mXqTitle = indexJsonData.getJSONObject("xq").getString("title");
            indexBean.mXqDesc = indexJsonData.getJSONObject("xq").getString("desc");
            indexBean.mHcTitle = indexJsonData.getJSONObject("hc").getString("title");
            indexBean.mHcDesc = indexJsonData.getJSONObject("hc").getString("desc");
            indexBean.mZsTitle = indexJsonData.getJSONObject("zs").getString("title");
            indexBean.mZsDesc= indexJsonData.getJSONObject("zs").getString("desc");
            indexBean.mColdTitle = indexJsonData.getJSONObject("cold").getString("title");
            indexBean.mColdDesc = indexJsonData.getJSONObject("cold").getString("desc");
            indexBean.mGjTitle = indexJsonData.getJSONObject("gj").getString("title");
            indexBean.mGjDesc = indexJsonData.getJSONObject("gj").getString("desc");
            indexBean.mUvTitle = indexJsonData.getJSONObject("uv").getString("title");
            indexBean.mUvDesc = indexJsonData.getJSONObject("uv").getString("desc");
            indexBean.mClTitle = indexJsonData.getJSONObject("cl").getString("title");
            indexBean.mClDesc = indexJsonData.getJSONObject("cl").getString("desc");
            indexBean.mGlassTitle= indexJsonData.getJSONObject("glass").getString("title");
            indexBean.mGlassDesc = indexJsonData.getJSONObject("glass").getString("desc");
            indexBean.mWash_CarTitle = indexJsonData.getJSONObject("wash_car").getString("title");
            indexBean.mWash_CarDesc = indexJsonData.getJSONObject("wash_car").getString("desc");
            indexBean.mAqiTitle = indexJsonData.getJSONObject("aqi").getString("title");
            indexBean.mAqiDesc = indexJsonData.getJSONObject("aqi").getString("desc");
            indexBean.mAcTitle = indexJsonData.getJSONObject("ac").getString("title");
            indexBean.mAcDesc= indexJsonData.getJSONObject("ac").getString("desc");

            indexBean.mMfTitle = indexJsonData.getJSONObject("mf").getString("title");
            indexBean.mMfDesc = indexJsonData.getJSONObject("mf").getString("desc");
            indexBean.mAgTitle = indexJsonData.getJSONObject("ag").getString("title");
            indexBean.mAgDesc = indexJsonData.getJSONObject("ag").getString("desc");
            indexBean.mPjTitle = indexJsonData.getJSONObject("pj").getString("title");
            indexBean.mPjDesc = indexJsonData.getJSONObject("pj").getString("desc");
            indexBean.mNlTitle = indexJsonData.getJSONObject("nl").getString("title");
            indexBean.mNlDesc = indexJsonData.getJSONObject("nl").getString("desc");
            indexBean.mPkTitle = indexJsonData.getJSONObject("pk").getString("title");
            indexBean.mPkDesc = indexJsonData.getJSONObject("pk").getString("desc");

            todayWeatherBean.mIndexBean = indexBean;

          //  mWeatherBean.mTodayWeatherBean = todayWeatherBean;
            Log.d("todayWeatherBean",todayWeatherBean.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void parseCityInfo(JSONObject cityInfo) {
        CityInfoBean cityInfoBean = new CityInfoBean();
        try {
           // JSONObject cityInfoJsonData = cityInfo.getJSONObject("cityInfo");
            cityInfoBean.mCityName_C5 = cityInfo.getString("c5");
            cityInfoBean.mPostCode_C12 = cityInfo.getString("c12");
            cityInfoBean.mAreaCode_C11 = cityInfo.getString("c11");
            cityInfoBean.mAltitude_C15 = cityInfo.getString("c15");
            cityInfoBean.mLatitude = cityInfo.getDouble("latitude")+"";
            cityInfoBean.mLongitude = cityInfo.getDouble("longitude")+"";
            cityInfoBean.mRadarCode_C16 = cityInfo.getString("c16")+"";
            Log.d("citiInfo",cityInfoBean.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    private  static void parseNowJsonData(JSONObject nowData) {
        try {
            JSONObject now_apiDetail = nowData.getJSONObject("aqiDetail");
          //  parseApiDetailJsonData(now_apiDetail);
            nowWeatherBean = new NowWeatherBean();
            nowWeatherBean.mWeather_Code = nowData.getString("weather_code");
            nowWeatherBean.mWind_Direction = nowData.getString("wind_direction");
            nowWeatherBean.mTemperature_Time = nowData.getString("temperature_time");
            nowWeatherBean.mWind_Power = nowData.getString("wind_power");
            nowWeatherBean.mAqi = nowData.getInt("aqi")+"";
            nowWeatherBean.mSd = nowData.getString("sd");
            nowWeatherBean.mWeather = nowData.getString("weather");
            nowWeatherBean.mTemperature = nowData.getString("temperature");
            parseAqiDetailJsonData(now_apiDetail);
            Log.d("nowweather bean json",nowWeatherBean.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private static void parseAqiDetailJsonData(JSONObject now_apiDetail) {
        AqiDetailBean aqiDetailBean = new AqiDetailBean();
        try {
            aqiDetailBean.mCo = now_apiDetail.getDouble("co")+"";
            aqiDetailBean.mSo2 = now_apiDetail.getInt("so2")+"";
            aqiDetailBean.mArea = now_apiDetail.getString("area");
            aqiDetailBean.mO3 = now_apiDetail.getInt("o3")+"";
            aqiDetailBean.mNo2 = now_apiDetail.getInt("no2")+"";
            aqiDetailBean.mQuality = now_apiDetail.getString("quality");
            aqiDetailBean.mAqi = now_apiDetail.getInt("aqi")+"";
            aqiDetailBean.mPm10 = now_apiDetail.getInt("pm10")+"";
            aqiDetailBean.mPm2_5 = now_apiDetail.getInt("pm2_5")+"";
            aqiDetailBean.mPrimary_Pollutant = now_apiDetail.getString("primary_pollutant");
            Log.d("aqiDetailBean.toString()",aqiDetailBean.toString());
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }
}


