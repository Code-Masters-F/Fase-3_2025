public class ContaGenerica {
    
    private String numeroConta;
    private float saldo;
    private String agencia;
    private boolean localAtiva;

    
    public ContaGenerica() {}

   
    public ContaGenerica(String numeroConta, String agencia, float saldo, boolean localAtiva) {
        this.numeroConta = numeroConta;
        this.agencia = agencia;
        this.saldo = saldo;
        this.localAtiva = localAtiva;
    }

    
    public String getNumeroConta() {
        return numeroConta;
    }

    public void setNumeroConta(String numeroConta) {
        this.numeroConta = numeroConta;
    }

    public float getSaldo() {
        return saldo;
    }

    public void setSaldo(float saldo) {
        this.saldo = saldo;
    }

    public String getAgencia() {
        return agencia;
    }

    public void setAgencia(String agencia) {
        this.agencia = agencia;
    }

    public boolean isLocalAtiva() {
        return localAtiva;
    }

    public void setLocalAtiva(boolean localAtiva) {
        this.localAtiva = localAtiva;
    }

   
    public void depositarValor(float valor) {
        if (valor > 0) {
            this.saldo += valor;
        }
    }

   
    public void depositarValor(float valor, String descricao) {
        if (valor > 0) {
            this.saldo += valor;
            System.out.println("Depósito realizado: " + descricao);
        }
    }
}
