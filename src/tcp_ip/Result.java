package tcp_ip;

import java.util.ArrayList;

public class Result {
    private String hostname;
    private ArrayList<Integer> success_ports = new ArrayList<Integer>();
    private ArrayList<Integer> fail_ports = new ArrayList<Integer>();

    public String getHostname() {
        return hostname;
    }


    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public void setSuccess_port(int success_port) {
        this.success_ports.add(success_port);
    }

    public void setFail_port(int fail_port) {
        this.fail_ports.add(fail_port);
    }
}
