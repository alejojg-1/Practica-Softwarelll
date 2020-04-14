package model;


import model.bussinesException.BussinesException;
import model.util.Validator;

public class Inventario {
    public static final String CANTIDAD_INVENTARIO_ES_MAYOR_AL_EXISTENTE ="La cantidad a retirar es mayor a la cantidad del" +
            " producto disponible" ;
    public static final String PRODUCTO_REQUERIDO="El producto es requerido";
    public static final String CANTIDAD_INVENTARIO_REQUERIDA="La cantidad inventario es requerida";
    public static final String CANTIDAD_PRODUCTO_REQUERIDA="La cantidad producto es requerida";
    public static final String CANTIDAD_LIMITE_SUPERIOR_REQUERIDA="La cantidad limite superior es requerida";
    public static final String CANTIDAD_LIMITE_INFERIOR_REQUERIDA="La cantidad limite inferior es requerida";
    public static final String CANTIDAD_NEGATIVA_PRODUCTO = "La cantidad de producto no puede ser  menor que cero.";
    public static final String CANTIDAD_NEGATIVA_IVENTARIO = "La cantidad de inventario no puede ser  menor que cero.";
    public static final String CANTIDAD_NEGATIVA_LIMITE_SUPERIOR = "La cantidad de limite superior no puede ser  menor que cero.";
    public static final String CANTIDAD_NEGATIVA_LIMITE_INFERIOR = "La cantidad de limite inferiro no puede ser  menor que cero.";
    public static final String CANTIDAD_NEGATIVA ="La cantidad no puede ser  menor que cero." ;
    public static final String LIMITE_INFERIOR_ALCANZADO = "La cantidad del producto es menor a 5";
    public static final String LIMITE_SUPERIOR_ALCANZADO = "La cantidad del producto ha sobrepasado el tope";
    private int idInventario;
    private int cantidadInventario;
    private Producto producto;
    private int limiteInferio;
    private int limiteSuperior;


    private Inventario() {
        super();
    }



    public static class inventarioBuilder {


        private int idInventario;
        private Producto producto;
        private int cantidadInventario;
        private int limiteInferio;
        private int limiteSuperior;

        public inventarioBuilder setLimiteInferio(int limiteInferio) {
            this.limiteInferio = limiteInferio;
            return this;
        }

        public inventarioBuilder setLimiteSuperior(int limiteSuperior) {
            this.limiteSuperior = limiteSuperior;
            return this;
        }


        public inventarioBuilder setCantidadInventario(int cantidadInventario) {
            this.cantidadInventario = cantidadInventario;
            return this;
        }


        public inventarioBuilder setIdInventario(int idInventario) {
            this.idInventario = idInventario;
            return this;
        }

        public inventarioBuilder setProducto(Producto producto) {
            this.producto = producto;
            return this;
        }

        public Inventario build() throws BussinesException {
            Inventario inventario=new Inventario();
            inventario.idInventario=this.idInventario;
            Validator.validarCantidadNegativa(producto.getCantidad(),CANTIDAD_NEGATIVA_PRODUCTO);
            Validator.validarProductoNulo(producto,PRODUCTO_REQUERIDO);
            Validator.validarCantidadVacia(producto.getCantidad(),CANTIDAD_PRODUCTO_REQUERIDA);
            inventario.producto=this.producto;
            Validator.validarCantidadNegativa(cantidadInventario,CANTIDAD_NEGATIVA_IVENTARIO);
            Validator.validarCantidadVacia(cantidadInventario, CANTIDAD_INVENTARIO_REQUERIDA);
            Validator.validarInventarioTransaccion(producto.getCantidad(),cantidadInventario,CANTIDAD_INVENTARIO_ES_MAYOR_AL_EXISTENTE);
            inventario.cantidadInventario=this.cantidadInventario;
            Validator.validarCantidadNegativa(limiteInferio,CANTIDAD_NEGATIVA_LIMITE_INFERIOR);
            Validator.validarCantidadVacia(limiteInferio, CANTIDAD_LIMITE_INFERIOR_REQUERIDA);
            Validator.validarLimiteInferior(producto.getCantidad(),limiteInferio, LIMITE_INFERIOR_ALCANZADO);
            inventario.limiteInferio=this.limiteInferio;
            Validator.validarCantidadNegativa(limiteSuperior,CANTIDAD_NEGATIVA_LIMITE_SUPERIOR);
            Validator.validarCantidadVacia(limiteSuperior, CANTIDAD_LIMITE_SUPERIOR_REQUERIDA);
            Validator.validarLimiteSuperior(producto.getCantidad(),limiteSuperior,  LIMITE_SUPERIOR_ALCANZADO);
            inventario.limiteSuperior=this.limiteSuperior;
            return inventario;

        }


    }


    public int retirarProducto(){
        return (producto.getCantidad() - cantidadInventario);
    }

    public int ingresarProducto(){
        return ((producto.getCantidad() + cantidadInventario));
    }






}


