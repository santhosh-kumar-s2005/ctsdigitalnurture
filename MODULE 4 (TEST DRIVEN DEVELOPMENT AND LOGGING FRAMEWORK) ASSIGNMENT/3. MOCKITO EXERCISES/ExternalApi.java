public interface ExternalApi {
    String getData();
    String getDataById(int id);
    void sendData(String data);
    void processData(String data);
    String fetchRecord(String key);
}
