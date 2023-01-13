package parcatakip.parcatakip.core;

public class ErrorDataResult <T> extends DataResult<T>{
    public ErrorDataResult(T data,String message){
        super(data,false,message);
    }
    public ErrorDataResult(T data){
        super(data,false,"İşlem Başarılı");
    }
    public ErrorDataResult(String message){
        super(null,false,message);
    }
}
