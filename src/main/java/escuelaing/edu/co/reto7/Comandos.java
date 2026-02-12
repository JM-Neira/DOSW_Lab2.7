package escuelaing.edu.co.reto7;


class ComandoEncenderLuz implements Comando {
    private Luz luz;
    private String usuario;
    private int intensidadAnterior;
    
    public ComandoEncenderLuz(Luz luz, String usuario) {
        this.luz = luz;
        this.usuario = usuario;
    }
    
    @Override
    public void ejecutar() {
        intensidadAnterior = luz.getIntensidad();
        luz.encender();
    }
    
    @Override
    public void deshacer() {
        luz.ajustarIntensidad(intensidadAnterior);
    }
    
    @Override
    public String getDescripcion() {
        return "Luz encendida";
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
}


class ComandoApagarLuz implements Comando {
    private Luz luz;
    private String usuario;
    private int intensidadAnterior;
    
    public ComandoApagarLuz(Luz luz, String usuario) {
        this.luz = luz;
        this.usuario = usuario;
    }
    
    @Override
    public void ejecutar() {
        intensidadAnterior = luz.getIntensidad();
        luz.apagar();
    }
    
    @Override
    public void deshacer() {
        luz.ajustarIntensidad(intensidadAnterior);
    }
    
    @Override
    public String getDescripcion() {
        return "Luz apagada";
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
}

class ComandoAbrirPuerta implements Comando {
    private Puerta puerta;
    private String usuario;
    private boolean estabaCerrada;
    
    public ComandoAbrirPuerta(Puerta puerta, String usuario) {
        this.puerta = puerta;
        this.usuario = usuario;
    }
    
    @Override
    public void ejecutar() {
        estabaCerrada = !puerta.isAbierta();
        puerta.abrir();
    }
    
    @Override
    public void deshacer() {
        if (estabaCerrada) {
            puerta.cerrar();
        }
    }
    
    @Override
    public String getDescripcion() {
        return "Puerta abierta";
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
}

class ComandoReproducirMusica implements Comando {
    private SistemaMusica sistema;
    private String cancion;
    private String usuario;
    private boolean estabaEncendido;
    
    public ComandoReproducirMusica(SistemaMusica sistema, String cancion, String usuario) {
        this.sistema = sistema;
        this.cancion = cancion;
        this.usuario = usuario;
    }
    
    @Override
    public void ejecutar() {
        estabaEncendido = sistema.isEncendido();
        sistema.reproducir(cancion);
    }
    
    @Override
    public void deshacer() {
        sistema.pausar();
        if (!estabaEncendido) {
            sistema.apagar();
        }
    }
    
    @Override
    public String getDescripcion() {
        return "Musica reproducida";
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
}

class ComandoAjustarVolumen implements Comando {
    private SistemaMusica sistema;
    private String usuario;
    private int nuevoVolumen;
    private int volumenAnterior;
    
    public ComandoAjustarVolumen(SistemaMusica sistema, int volumen, String usuario) {
        this.sistema = sistema;
        this.nuevoVolumen = volumen;
        this.usuario = usuario;
    }
    
    @Override
    public void ejecutar() {
        volumenAnterior = sistema.getVolumen();
        sistema.ajustarVolumen(nuevoVolumen);
    }
    
    @Override
    public void deshacer() {
        sistema.ajustarVolumen(volumenAnterior);
    }
    
    @Override
    public String getDescripcion() {
        return "Volumen ajustado a " + nuevoVolumen + "%";
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
}

class ComandoAjustarPersiana implements Comando {
    private Persiana persiana;
    private String usuario;
    private int nuevoNivel;
    private int nivelAnterior;
    
    public ComandoAjustarPersiana(Persiana persiana, int nivel, String usuario) {
        this.persiana = persiana;
        this.nuevoNivel = nivel;
        this.usuario = usuario;
    }
    
    @Override
    public void ejecutar() {
        nivelAnterior = persiana.getNivelApertura();
        persiana.ajustarNivel(nuevoNivel);
    }
    
    @Override
    public void deshacer() {
        persiana.ajustarNivel(nivelAnterior);
    }
    
    @Override
    public String getDescripcion() {
        return "Persiana ajustada";
    }
    
    @Override
    public String getUsuario() {
        return usuario;
    }
}