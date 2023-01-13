package parcatakip.parcatakip.core;

public class SuccessDataResult <T> extends DataResult<T>{
    public SuccessDataResult(T data,String message){
        super(data,true,message);
    }
    public SuccessDataResult(T data){
        super(data,true,"İşlem Başarılı");
    }
    public SuccessDataResult(String message){
        super(null,true,message);
    }
}
