package domain;

import java.io.Serializable;
import java.util.Objects;

public class Scene extends BaseEntity<Long> implements Serializable {
    protected String sceneName;

    public Scene() {
    }


    public Scene(Long _id, String _sname) {
        id = _id;
        sceneName = _sname;
    }

    public String getSceneName() {
        return sceneName;
    }

    public void setSceneName(String sceneName) {
        this.sceneName = sceneName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Scene)) return false;
        Scene scene = (Scene) o;
        return Objects.equals(id, scene.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, sceneName);
    }

    @Override
    public String toString() {
        return "Scene{" +
                "id=" + id +
                ", sceneName='" + sceneName + '\'' +
                '}';
    }
}
