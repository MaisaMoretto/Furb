export interface SubObjeto {
    propriedade1: string;
    propriedade2: string;
}

export interface Funcionario {
    id: number;
    nome: string;
    foto: string;
    email: string;
    subobjeto: SubObjeto;
}