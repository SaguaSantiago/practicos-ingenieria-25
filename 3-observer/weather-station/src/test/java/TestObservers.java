import org.junit.jupiter.api.Test;

public class TestObservers {

    @Test
    public void testThreeObservers() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);
    }

    @Test
    public void testRemoveObserver() {
        WeatherData weatherData = new WeatherData();

        Observer currentDisplay =
                new CurrentConditionsDisplay(weatherData);
        Observer statisticsDisplay = new StatisticsDisplay(weatherData);
        Observer forecastDisplay = new ForecastDisplay(weatherData);

        weatherData.registerObserver(currentDisplay);
        weatherData.registerObserver(statisticsDisplay);
        weatherData.registerObserver(forecastDisplay);

        weatherData.setMeasurements(80, 65, 30.4f);
        weatherData.setMeasurements(82, 70, 29.2f);
        weatherData.setMeasurements(78, 90, 29.2f);

        weatherData.removeObserver(forecastDisplay);
        weatherData.setMeasurements(62, 90, 28.1f);
    }

    @Test
    public void weatherDataChanged () {
        WeatherData wd = new WeatherData();
        
        Observer currentDisplay =
                new CurrentConditionsDisplay(wd);
        Observer statisticsDisplay = new StatisticsDisplay(wd);
        Observer forecastDisplay = new ForecastDisplay(wd);

        wd.registerObserver(forecastDisplay);
        wd.registerObserver(statisticsDisplay);
        wd.registerObserver(currentDisplay);

        wd.setMeasurements(10, 5, 100);

        wd.removeObserver(forecastDisplay);
        wd.removeObserver(statisticsDisplay);
        wd.removeObserver(currentDisplay);

        WeatherData wd2 = new WeatherData();
        
        wd2.registerObserver(forecastDisplay);
        wd2.registerObserver(statisticsDisplay);
        wd2.registerObserver(currentDisplay);
        wd2.setMeasurements(20, 10, 50);

    }

    @Test
    public void degreeStatisticsTest () {
        WeatherData weatherData = new WeatherData();

        Observer degreeDisplay = new DegreeStatisticsDisplay(weatherData);

        weatherData.registerObserver(degreeDisplay);

        weatherData.setMeasurements(70, 10, 1000);
        weatherData.setMeasurements(30, 10, 1000);
        weatherData.setMeasurements(40, 10, 1000);
    }    

}
