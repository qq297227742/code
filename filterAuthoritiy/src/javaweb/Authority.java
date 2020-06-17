package javaweb;

import java.util.Objects;

public class Authority {
    //显示到页面上的权限的名字
    private String displayName;
    //权限对应的 URL 地址：一个权限对应一个 URL
    private String  url;

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Authority() {
    }

    public Authority(String displayName, String url) {
        this.displayName = displayName;
        this.url = url;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Authority authority = (Authority) o;
        return url.equals(authority.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url);
    }
}
