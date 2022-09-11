import { IProduct } from "./products";

export interface ICart extends IProduct{
    ammount: number;
}