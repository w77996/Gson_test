package wu.pra.myapplication.wu.pra.bean;

/**
 * Created by Administrator on 2016/12/1.
 */
public class CityInfoBean {
    public String mCityName_C5;//城市名
    public String mPostCode_C12;//邮编
    public String mLongitude;
    public String mLatitude;
    public String mAreaCode_C11;
    public String mRadarCode_C16;
    public String mAltitude_C15;

    public String getmCityName_C5() {
        return mCityName_C5;
    }

    public void setmCityName_C5(String mCityName_C5) {
        this.mCityName_C5 = mCityName_C5;
    }

    public String getmPostCode_C12() {
        return mPostCode_C12;
    }

    public void setmPostCode_C12(String mPostCode_C12) {
        this.mPostCode_C12 = mPostCode_C12;
    }

    public String getmLongitude() {
        return mLongitude;
    }

    public void setmLongitude(String mLongitude) {
        this.mLongitude = mLongitude;
    }

    public String getmLatitude() {
        return mLatitude;
    }

    public void setmLatitude(String mLatitude) {
        this.mLatitude = mLatitude;
    }

    public String getmAreaCode_C11() {
        return mAreaCode_C11;
    }

    public void setmAreaCode_C11(String mAreaCode_C11) {
        this.mAreaCode_C11 = mAreaCode_C11;
    }

    public String getmRadarCode_C16() {
        return mRadarCode_C16;
    }

    public void setmRadarCode_C16(String mRadarCode_C16) {
        this.mRadarCode_C16 = mRadarCode_C16;
    }

    public String getmAltitude_C15() {
        return mAltitude_C15;
    }

    public void setmAltitude_C15(String mAltitude_C15) {
        this.mAltitude_C15 = mAltitude_C15;
    }

    @Override
    public String toString() {
        return "CityInfoBean{" +
                "mCityName_C5='" + mCityName_C5 + '\'' +
                ", mPostCode_C12='" + mPostCode_C12 + '\'' +
                ", mLongitude='" + mLongitude + '\'' +
                ", mLatitude='" + mLatitude + '\'' +
                ", mAreaCode_C11='" + mAreaCode_C11 + '\'' +
                ", mRadarCode_C16='" + mRadarCode_C16 + '\'' +
                ", mAltitude_C15='" + mAltitude_C15 + '\'' +
                '}';
    }
}
