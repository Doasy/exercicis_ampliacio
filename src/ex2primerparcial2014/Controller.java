package ex2primerparcial2014;


import java.util.Observable;

//Trenquem el principi OBERT-TANCAT al principi
public class Controller extends Observable{//ignorar lo de observable
    private Resolution resolution;
    private Object document;
    private ControllerAbstractFactory factory;
    private Visualizer visualizer;
    private Printer printer;

    public void updateResolution(Resolution resolution){//observable
        this.resolution = resolution;
        factory = ControllerFactoryMethod.createFactory(this.resolution);
        visualizer = factory.createVisualizer();
        printer = factory.createPrinter();
        setChanged();
        notifyObservers();
    }

    public void visualize(){
        visualizer.visualize(this.document);
    }

    public void print(){
        printer.print(this.document);
    }
}
