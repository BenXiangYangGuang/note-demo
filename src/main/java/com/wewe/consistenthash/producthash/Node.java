package com.wewe.consistenthash.producthash;

/**
 * Author: fei2
 * Date:  18-8-1 下午6:19
 * Description:对应服务器节点
 * Refer To:
 */
public class Node {
    // 节点名称
    private String name;
    // 节点IP
    private String ip;
    // 节点端口号
    private int port;
    // 节点密码
    private String password;


    public Node(String name, String ip, int port, String password) {
        this.name = name;
        this.ip = ip;
        this.port = port;
        this.password = password;
    }


    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getIp() {
        return ip;
    }


    public void setIp(String ip) {
        this.ip = ip;
    }


    public int getPort() {
        return port;
    }


    public void setPort(int port) {
        this.port = port;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "Node [name=" + name + ", ip=" + ip + ", port=" + port
                + ", password=" + password + "]";
    }
}