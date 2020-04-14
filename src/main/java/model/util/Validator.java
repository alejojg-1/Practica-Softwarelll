package model.util;

import model.Producto;
import model.bussinesException.BussinesException;

import java.util.Date;

public class Validator {

    public static void validarProductoNulo(Producto producto,String mensaje) throws BussinesException {
        if (producto == null) {
            throw new BussinesException(mensaje);
        }
    }

    public static void validarInventarioTransaccion(int cantidadProducto,int cantidadInventario,String mensaje) throws BussinesException {
        if (cantidadInventario>cantidadProducto) {
            throw new BussinesException(mensaje);
        }
    }

    public static void  validarCantidadVacia(int cantidad, String mensaje) throws BussinesException {
        if(cantidad==0){
            throw new BussinesException(mensaje);
        }
    }
    public static void  validarCantidadNegativa(int cantidad, String mensaje) throws BussinesException {
        if(cantidad<0){
            throw new BussinesException(mensaje);
        }
    }

    public static void validarLimiteSuperior(int cantidad,int limiteSuperior,String mensaje) throws BussinesException {
        if ( cantidad>limiteSuperior) {
            throw new BussinesException(mensaje);
        }
    }
    public static void validarLimiteInferior(int cantidad,int limiteInferior,String mensaje) throws BussinesException {
        if (cantidad<limiteInferior) {
            throw new BussinesException(mensaje);
        }
    }

}
