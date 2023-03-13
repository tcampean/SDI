import domain.Artist;
import repository.ArtistRepository;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ui.SceneView;

public class Main {

    public static void main(String[] args)
    {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("config");
        SceneView artists = context.getBean(SceneView.class);
        artists.run();


    }
}

