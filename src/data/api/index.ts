import axios from "axios"
import { environment } from "../../config/environment";

export const getRequestWeatherApi = async (url: string, headers?: any): Promise<any> => {
    return await axios.get(`${environment.baseURLWeather}/${url}`, headers);
}
export const getRequest = async (url: string, headers?: any): Promise<any> => {
    return await axios.get(`${environment.baseURLAPI}/${url}`, headers);
}
export const postRequest = (url: string, data: any, headers?: any) => {}
export const putRequest = (url: string,data: any, headers?: any) => {}
export const deleteRequest = (url: string, headers?: any) => {}