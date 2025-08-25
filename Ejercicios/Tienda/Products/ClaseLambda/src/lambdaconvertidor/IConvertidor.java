package lambdaconvertidor;

@FunctionalInterface// solo para validar que sea una Interface funcional
public interface IConvertidor <T, R>{

    R convertir(T t);
}
