export class Retiro {
    idRetirante: string;
    fecha: Date;
    descripcion: string;
    monto: number;
    idRecepcionista: string;

    constructor(idRetirante: string, fecha: Date, descripcion: string, monto: number, idRecepcionista: string) {
        this.idRetirante = idRetirante
        this.fecha = fecha
        this.descripcion = descripcion
        this.monto = monto
        this.idRecepcionista = idRecepcionista
    }
}