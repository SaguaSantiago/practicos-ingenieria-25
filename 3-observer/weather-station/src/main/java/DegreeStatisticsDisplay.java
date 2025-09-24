public class DegreeStatisticsDisplay implements Observer, DisplayElement {
    WeatherData weatherData;
    float max = Float.NEGATIVE_INFINITY;
    float min = Float.POSITIVE_INFINITY;
    float tempSum = 0;
    int registered = 0;
    public DegreeStatisticsDisplay () {}

    public DegreeStatisticsDisplay (WeatherData wd){
        this.weatherData = wd;
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        float celciusTemp = (temp - 32) * (5.0f / 9.0f);
        this.tempSum += celciusTemp;
        registered++;

        if(celciusTemp > max) max = celciusTemp;
        if(celciusTemp < min) min = celciusTemp;

        display();
    }

    @Override
    public void display() {
        System.out.println("Avg/Max/Min temperature = " + (tempSum / registered)
			+ "/" + max + "/" + min);
    }
}
