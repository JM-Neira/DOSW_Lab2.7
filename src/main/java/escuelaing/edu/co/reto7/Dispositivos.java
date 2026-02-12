package escuelaing.edu.co.reto7;


class Luz {
    private String ubicacion;
    private boolean encendida;
    private int intensidad;
    
    public Luz(String ubicacion) {
        this.ubicacion = ubicacion;
        this.encendida = false;
        this.intensidad = 0;
    }
    
    public void encender() {
        encendida = true;
        intensidad = 100;
    }
    
    public void apagar() {
        encendida = false;
        intensidad = 0;
    }
    
    public void ajustarIntensidad(int nivel) {
        if (nivel >= 0 && nivel <= 100) {
            intensidad = nivel;
            encendida = nivel > 0;
        }
    }
    
    public boolean isEncendida() {
        return encendida;
    }
    
    public int getIntensidad() {
        return intensidad;
    }
    
    public String getUbicacion() {
        return ubicacion;
    }
}


class Puerta {
    private String ubicacion;
    private boolean abierta;
    private boolean bloqueada;
    
    public Puerta(String ubicacion) {
        this.ubicacion = ubicacion;
        this.abierta = false;
        this.bloqueada = true;
    }
    
    public void abrir() {
        if (!bloqueada) {
            abierta = true;
        } else {
            bloqueada = false;
            abierta = true;
        }
    }
    
    public void cerrar() {
        abierta = false;
    }
    
    public void bloquear() {
        bloqueada = true;
        abierta = false;
    }
    
    public void desbloquear() {
        bloqueada = false;
    }
    
    public boolean isAbierta() {
        return abierta;
    }
    
    public boolean isBloqueada() {
        return bloqueada;
    }
}


class SistemaMusica {
    private boolean encendido;
    private int volumen;
    private String cancionActual;
    
    public SistemaMusica() {
        this.encendido = false;
        this.volumen = 0;
        this.cancionActual = "";
    }
    
    public void encender() {
        encendido = true;
    }
    
    public void apagar() {
        encendido = false;
    }
    
    public void reproducir(String cancion) {
        if (!encendido) {
            encendido = true;
        }
        cancionActual = cancion;
    }
    
    public void pausar() {
        cancionActual = "";
    }
    
    public void ajustarVolumen(int nivel) {
        if (nivel >= 0 && nivel <= 100) {
            volumen = nivel;
        }
    }
    
    public int getVolumen() {
        return volumen;
    }
    
    public boolean isEncendido() {
        return encendido;
    }
    
    public String getCancionActual() {
        return cancionActual;
    }
}


class Persiana {
    private String ubicacion;
    private int nivelApertura;
    
    public Persiana(String ubicacion) {
        this.ubicacion = ubicacion;
        this.nivelApertura = 0;
    }
    
    public void abrir() {
        nivelApertura = 100;
    }
    
    public void cerrar() {
        nivelApertura = 0;
    }
    
    public void ajustarNivel(int nivel) {
        if (nivel >= 0 && nivel <= 100) {
            nivelApertura = nivel;
        }
    }
    
    public int getNivelApertura() {
        return nivelApertura;
    }
}