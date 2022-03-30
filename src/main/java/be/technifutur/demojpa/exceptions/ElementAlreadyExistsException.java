package be.technifutur.demojpa.exceptions;

public class ElementAlreadyExistsException extends RuntimeException
{
    public ElementAlreadyExistsException()
    {
        super("l'element existe deja");
    }
}
