package db;

public class DbIntegritException extends RuntimeException{

    private static final long serialVersionUID = 1l;

    public DbIntegritException(String msg){
        super(msg);
    }
}
