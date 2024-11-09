export class Credencial {
    cedula: string;
    contraseña: string;

    constructor(cedula: string, contraseña: string) {
        this.cedula = cedula
        this.contraseña = contraseña;
    }
}