package controllers;

public abstract class ControllerFactory {

        public abstract AnadirTema getanadirTemaController();

        public abstract EliminarTema getEliminarController();

        public abstract VerVotos getVerVotosController();

        public abstract Votar getVotarController();

    
}
