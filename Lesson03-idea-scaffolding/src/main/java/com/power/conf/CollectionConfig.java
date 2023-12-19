package com.power.conf;

import com.power.pojo.MyServer;
import com.power.pojo.User;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@ConfigurationProperties
public class CollectionConfig {
    private List<MyServer> servers;
    private Map<String, User> users;
    private String [] names;
    //set | get ,toString


    @Override
    public String toString() {
        return "CollectionConfig{" +
                "servers=" + servers +
                ", users=" + users +
                ", names=" + Arrays.toString(names) +
                '}';
    }

    public List<MyServer> getServers() {
        return servers;
    }

    public void setServers(List<MyServer> servers) {
        this.servers = servers;
    }

    public Map<String, User> getUsers() {
        return users;
    }

    public void setUsers(Map<String, User> users) {
        this.users = users;
    }

    public String[] getNames() {
        return names;
    }

    public void setNames(String[] names) {
        this.names = names;
    }
}