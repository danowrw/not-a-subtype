package org.acme;

public class Organisation {
    String login;
    Long id;
    String node_id;
    String url;
    String repos_url;
    String events_url;
    String hooks_url;
    String issues_url;
    String members_url;
    String public_members_url;
    String avatar_url;
    String description;

    public String getLogin() {
        return login;
    }

    public Long getId() {
        return id;
    }

    public String getNode_id() {
        return node_id;
    }

    public String getUrl() {
        return url;
    }

    public String getRepos_url() {
        return repos_url;
    }

    public String getEvents_url() {
        return events_url;
    }

    public String getHooks_url() {
        return hooks_url;
    }

    public String getIssues_url() {
        return issues_url;
    }

    public String getMembers_url() {
        return members_url;
    }

    public String getPublic_members_url() {
        return public_members_url;
    }

    public String getAvatar_url() {
        return avatar_url;
    }

    public String getDescription() {
        return description;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNode_id(String node_id) {
        this.node_id = node_id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setRepos_url(String repos_url) {
        this.repos_url = repos_url;
    }

    public void setEvents_url(String events_url) {
        this.events_url = events_url;
    }

    public void setHooks_url(String hooks_url) {
        this.hooks_url = hooks_url;
    }

    public void setIssues_url(String issues_url) {
        this.issues_url = issues_url;
    }

    public void setMembers_url(String members_url) {
        this.members_url = members_url;
    }

    public void setPublic_members_url(String public_members_url) {
        this.public_members_url = public_members_url;
    }

    public void setAvatar_url(String avatar_url) {
        this.avatar_url = avatar_url;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Organisation{" +
                "login='" + login + '\'' +
                ", id=" + id +
                ", node_id='" + node_id + '\'' +
                ", url='" + url + '\'' +
                ", repos_url='" + repos_url + '\'' +
                ", events_url='" + events_url + '\'' +
                ", hooks_url='" + hooks_url + '\'' +
                ", issues_url='" + issues_url + '\'' +
                ", members_url='" + members_url + '\'' +
                ", public_members_url='" + public_members_url + '\'' +
                ", avatar_url='" + avatar_url + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
