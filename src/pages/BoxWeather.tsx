import React, { useEffect } from "react";
import NavbarWeather from "../components/navbar-weather";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import Now from "../components/weather/Now";
import Hourly from "../components/weather/Hourly";
import Daily from "../components/weather/Daily";
import { connect } from 'react-redux';
import { getWeatherNowRequest, getWeatherHourlyRequest, getWeatherDailyRequest, getWeatherFavoriteRequest, getWeatherSearchRequest } from "../redux/effects/weatherEffects"
import { getListcityRequest } from "../redux/effects/cityEffects"
import { bindActionCreators } from 'redux';

interface IBoxWeather {
  propsData: any;
  cityData: any;
  getWeatherNowRequest: (city: any) => void;
  getWeatherFavoriteRequest: (userId: any) => void;
  getListcityRequest: () => void;
  getWeatherSearchRequest: (city:any) => void;
  match: any;
}

const BoxWeather: React.FC<IBoxWeather> = ({ propsData, cityData, getWeatherNowRequest, match, getWeatherSearchRequest }) => {

  // lấy param từ Link truyền vào
  const { city } = match.params;

  // Sau khi Component được sinh ra thì chạy hàm getWeatherNowRequest() có param là city để lấy ra danh sách thời tiết hiện tại
  useEffect(() => {
    getWeatherSearchRequest(city);
    getWeatherNowRequest(city);
  }, [city]);

  // điều kiện nếu danh sách thời tiết chưa load xong
  if (!propsData.success) {
    return (
      <div className="loading" >Loading ... </div>
    );
  }

  return (
    <div className="main-container">
      <div className="main-container-innner-wrap">
          <NavbarWeather propsData={propsData.weather} city={cityData} favorite={propsData.favorite} userID={localStorage.getItem("userID")} />
          <Switch>
            <Route path="/now/:city">
              <Now propsData={propsData.weather} />
            </Route>
            <Route path="/search/now">
              <Now propsData={propsData.weather} />
            </Route>
            <Route path="/hourly/:city" component={Hourly} />
            <Route path="/daily/:city" component={Daily} />
            {/* <Route path="/favourites/:city" component={Favourite} /> */}
          </Switch>
      </div>
    </div>
  );
};

const mapStateToProps = (state: any) => {
  return {
    propsData: state.weatherReducer,
    cityData: state.cityReducer,
    userData: state.userReducer,
  }
}

const mapDispatchToProps = (dispatch: any) => bindActionCreators(
  {
    getWeatherNowRequest,
    getWeatherHourlyRequest,
    getWeatherDailyRequest,
    getListcityRequest,
    getWeatherFavoriteRequest,
    getWeatherSearchRequest,
  }
  , dispatch);

export default connect(mapStateToProps, mapDispatchToProps)(BoxWeather);
