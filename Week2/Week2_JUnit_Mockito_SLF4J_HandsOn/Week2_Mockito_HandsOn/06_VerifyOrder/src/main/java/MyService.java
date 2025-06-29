public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public void runProcess() {
        api.connect();
        api.fetchData();
        api.disconnect();
    }
}
