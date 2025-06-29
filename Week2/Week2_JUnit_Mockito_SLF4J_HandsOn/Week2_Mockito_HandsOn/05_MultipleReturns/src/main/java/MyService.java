public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String getStatus() {
        return api.fetchStatus();
    }
}
