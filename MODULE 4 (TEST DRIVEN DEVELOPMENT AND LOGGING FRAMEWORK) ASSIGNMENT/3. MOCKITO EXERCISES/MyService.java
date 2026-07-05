public class MyService {

    private ExternalApi externalApi;

    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }

    public String fetchData() {
        return externalApi.getData();
    }

    public String fetchDataById(int id) {
        return externalApi.getDataById(id);
    }

    public void sendData(String data) {
        externalApi.sendData(data);
    }

    public void processData(String data) {
        externalApi.processData(data);
    }

    public String fetchRecord(String key) {
        return externalApi.fetchRecord(key);
    }

    public String fetchMultipleTimes() {
        String first = externalApi.getData();
        String second = externalApi.getData();
        String third = externalApi.getData();
        return first + "," + second + "," + third;
    }

    public void performOrderedOperations(String data) {
        externalApi.getData();
        externalApi.sendData(data);
        externalApi.processData(data);
    }
}
