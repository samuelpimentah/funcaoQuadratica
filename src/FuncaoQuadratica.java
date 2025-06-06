public class FuncaoQuadratica {
    public static void main(String[] args) {
        //declaração das variáveis dos coeficientes a, b, c
        double coeficienteA = -1;
        double coeficienteB = 5;
        double coeficienteC = 10;

        //usando o método resolverFuncao
        String respostaFuncao = resolverFuncao(coeficienteA, coeficienteB, coeficienteC);
        System.out.println(respostaFuncao);
    }
    //método resolverFuncao
    public static String resolverFuncao(double a, double b, double c) {
        //declaração de variáveis do método
        double delta = b * b - (4 * a * c);
        int quantidadeRaizes = 0;
        double raizX1;
        double raizX2;
        double xVertice;
        double yVertice;
        String tipoFuncao;
        String pontoV = "";
        String parabola = "";

        //função é quadrática
        if (a != 0) {
            tipoFuncao = "FUNÇÃO QUADRÁTICA";

            //verificando a direção da parábola
            if (a < 0) {
                pontoV = "PONTO MÁXIMO";
                parabola = "VOLTADA PARA BAIXO";
            }
            else if (a > 0) {
                pontoV = "PONTO MÍNIMO";
                parabola = "VOLTADA PARA CIMA";
            }

            //calculando a quantidade de raízes
            if (delta > 0) {
                quantidadeRaizes = 2;
            }
            else if (delta == 0) {
                quantidadeRaizes = 1;
            }

            //calculando as raízes e retornando a String com as informações
            if (quantidadeRaizes != 0) {
                raizX1 = (-b + Math.sqrt(delta)) / (2 * a);
                if (raizX1 == -0) {
                    raizX1 = 0;
                }
                if (quantidadeRaizes == 1) {
                    xVertice = -(b / (2 * a));
                    yVertice = -(delta / (4 * a));
                    return String.format("\u001B[36m%s \nParábola = %s \nDelta = %.2f \nQntd raízes = %d \nValor x = %.2f \nVértice = (%.1f; %.1f) -> %s \n\u001B[0m", tipoFuncao, parabola, delta, quantidadeRaizes, raizX1, xVertice, yVertice, pontoV);
                }
                else {
                    raizX2 = (-b - Math.sqrt(delta)) / (2 * a);
                    if (raizX2 == -0) {
                        raizX2 = 0;
                    }
                    xVertice = -(b / (2 * a));
                    yVertice = -(delta / (4 * a));
                    return String.format("\u001B[36m%s \nParábola = %s \nDelta = %.2f \nQntd raízes = %d \nValor x1 = %.1f \nValor x2 = %.1f \nVértice = (%.1f; %.1f) -> %s \n\u001B[0m", tipoFuncao, parabola, delta, quantidadeRaizes, raizX1, raizX2, xVertice, yVertice, pontoV);
                }
            }
            else {
                xVertice = -(b / (2 * a));
                yVertice = -(delta / (4 * a));
                return "\u001B[41mNão existem raízes reais\u001B[0m" + String.format("\u001B[36m\n%s \nParábola = %s \nVértice = (%.1f; %.1f) -> %s \n\u001B[0m", tipoFuncao, parabola, xVertice, yVertice, pontoV);
            }
        }
        //função afim
        else {
            //declaração de variáveis do método
            tipoFuncao = "FUNÇÃO AFIM";
            raizX1 = (-c) / b;
            quantidadeRaizes = 1;

            //verificando a direção da reta
            if (b > 0) {
                parabola = "CRESCENTE";
            }
            else if (b < 0) {
                parabola = "DECRESCENTE";
            }
            //se a função for constante
            else {
                return String.format("\u001B[41mFUNÇÃO AFIM CONSTANTE, tal que Y é sempre %.1f para qualquer X\u001B[0m", c);
            }
            //retorno da String com as informações
            return String.format("\u001B[35m%s \nQntd raízes = %d \nValor x = %.1f \nRaíz = (%.1f; 0) \nCoeficiente linear = (0; %.1f) \nReta -> %s \n\u001B[0m", tipoFuncao, quantidadeRaizes, raizX1, raizX1, c, parabola);
        }
    }
}