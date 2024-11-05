export class IngresoProducto {
    idProducto?: number;
    cantidad?: number;
    monto?: number;
    metodoPago?: string;
    fecha?: Date;
    idHuesped?: string;
    idRecepcionista?: string;
    
    constructor(
        idProducto: number,
        idHuesped: string,
        idRecepcionista: string,
        fecha: Date,
        cantidad: number,
        monto: number,
        metodoPago: string
    ) {
        this.idProducto = idProducto;
        this.idHuesped = idHuesped;
        this.idRecepcionista = idRecepcionista;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.monto = monto;
        this.metodoPago = metodoPago;
    }
}