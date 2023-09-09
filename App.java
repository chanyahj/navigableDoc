import controller.NavDocController;
import model.NavigableDocModel;
import view.NavDocView;

public class App {
    public static void main(String[] args) {
        NavigableDocModel<Integer> navDocModel=new NavigableDocModel<>();
        NavDocView view=new NavDocView();
        NavDocController controller=new NavDocController(navDocModel, view);
        view.setVisible(true);
    }

}
