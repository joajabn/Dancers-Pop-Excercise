package pl.paniodprogramowania.findBugsProject.exceptions;

public class DancerNotFoundException extends RuntimeException {
    public DancerNotFoundException(long dancerId){
        super("Dancer not found with id: " + dancerId);
    }
}
