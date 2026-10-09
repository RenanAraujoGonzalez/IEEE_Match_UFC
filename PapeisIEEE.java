import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
public class PapeisIEEE {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        List<Assinatura> areas = new ArrayList<>();
        areas.add(new Assinatura("comissao", "Gestão de Projetos", 11, new String[]{"P2", "P1"}, new String[]{"H9"}, new String[]{"I9"}, new String[]{"A10", "A1"}));
        areas.add(new Assinatura("comissao", "Atividades", 11, new String[]{"P1", "P3"}, new String[]{"H9", "H11"}, new String[]{"I8"}, new String[]{"A1"}));
        areas.add(new Assinatura("comissao", "Comunicação", 10, new String[]{"P5"}, new String[]{"H6", "H7"}, new String[]{"I8"}, new String[]{"A3"}));
        areas.add(new Assinatura("comissao", "Gestão de Pessoas", 13, new String[]{"P3"}, new String[]{"H9", "H7"}, new String[]{"I9", "I7"}, new String[]{"A10", "A1"}));
        areas.add(new Assinatura("comissao", "Relações Internacionais", 11, new String[]{"P6", "P1"}, new String[]{"H10"}, new String[]{"I10"}, new String[]{"A6"}));
        areas.add(new Assinatura("comissao", "Secretaria", 10, new String[]{"P2"}, new String[]{"H7", "H9"}, new String[]{"I9"}, new String[]{"A5"}));
        areas.add(new Assinatura("comissao", "Finanças", 10, new String[]{"P2"}, new String[]{"H8"}, new String[]{"I9"}, new String[]{"A7", "A6"}));
        areas.add(new Assinatura("comissao", "Infraestrutura", 11, new String[]{"P2", "P4"}, new String[]{"H3", "H9"}, new String[]{"I9"}, new String[]{"A8"}));
        areas.add(new Assinatura("comissao", "Webmaster", 10, new String[]{"P4"}, new String[]{"H2", "H1"}, new String[]{"I9", "I4"}, new String[]{"A9"}));
        areas.add(new Assinatura("comissao", "Proj. Técnicos: Sistemas Autônomos e IA", 15, new String[]{"P4"}, new String[]{"H1", "H4", "H5"}, new String[]{"I1", "I4"}, new String[]{"A2"}));
        areas.add(new Assinatura("comissao", "Proj. Técnicos: Tecnologias Assistivas, Educacionais e Socioambientais", 13, new String[]{"P3", "P5"}, new String[]{"H3", "H1", "H11"}, new String[]{"I5"}, new String[]{"A2"}));
        areas.add(new Assinatura("grupos", "WIE", 13, new String[]{"P3", "P1"}, new String[]{"H11", "H9"}, new String[]{"I7"}, new String[]{"A4", "A1"}));
        areas.add(new Assinatura("grupos", "SIGHT", 14, new String[]{"P3"}, new String[]{"H3", "H1", "H9"}, new String[]{"I6"}, new String[]{"A2", "A1"}));
        areas.add(new Assinatura("capitulo", "RAS", 12, new String[]{"P4"}, new String[]{"H4", "H1", "H3"}, new String[]{"I1"}, new String[]{"A2"}));
        areas.add(new Assinatura("capitulo", "CASS", 10, new String[]{"P4"}, new String[]{"H3", "H5"}, new String[]{"I2"}, new String[]{"A2"}));
        areas.add(new Assinatura("capitulo", "TEC/PELS/IAS", 10, new String[]{"P4"}, new String[]{"H12", "H3"}, new String[]{"I3"}, new String[]{"A2"}));
        
        Aluno a1 = new Aluno();
        entradaDados(a1, entrada);
        calcularPontuacao(a1, areas.toArray(new Assinatura[0]));
        calcularCompatibilidade(areas.toArray(new Assinatura[0]));
        Assinatura[] prioridades = calcularPrioridades(areas.toArray(new Assinatura[0]));
        desempate(prioridades);
        apresentarResultados(prioridades, a1);
    }
    public static void entradaDados(Aluno aluno, Scanner entrada){
        System.out.println("IEEE Match UFC: descubra em 2 minutos qual área do IEEE combina com você. "
                + "\nResponda a 4 perguntas e receba sua comissão e seu grupo ou capítulo ideais, "
                + "\ncom a explicação de cada um.");
        System.out.println("Digite seu nome: ");
        aluno.setNome(entrada.nextLine());
        System.out.println("Você é membro do IEEE? {S} ou {N}: ");
        while(true){
            String valor = entrada.nextLine();
            if(valor.equals("S")){
                aluno.setEhMembro(true);
                break;
            } else if(valor.equals("N")){
                aluno.setEhMembro(false);
                break;
            } else{
                System.out.println("Entrada invalida");
            }
        }
        System.out.println("Qual é o seu perfil de interação?");
        System.out.println("{P1} Comunicativo e articulador (lidera, apresenta, mobiliza)");
        System.out.println("{P2} Organizado e metódico (prazos, controle, processos)");
        System.out.println("{P3} Acolhedor e empático (escuta, integra, cuida do clima)");
        System.out.println("{P4} Focado e independente (mergulha num problema técnico)");
        System.out.println("{P5} Criativo e expressivo (ideias, estética, narrativa)");
        System.out.println("{P6} Networker e negociador (faz contatos com facilidade)");
        System.out.println("{P0} nenhum\n");
        while(!entradaPerfil(aluno, entrada));
        System.out.println("Quais são suas habilidades?");
        System.out.println("H1 Programação");
        System.out.println("H2 Desenvolvimento web");
        System.out.println("H3 Eletrônica e hardware");
        System.out.println("H4 Robótica, automação e controle");
        System.out.println("H5 IA, dados e processamento de sinais");
        System.out.println("H6 Design, foto e edição de vídeo");
        System.out.println("H7 Redação e escrita");
        System.out.println("H8 Finanças, planilhas e orçamento");
        System.out.println("H9 Gestão de projetos e tempo");
        System.out.println("H10 Inglês e idiomas");
        System.out.println("H11 Didática (ensinar e explicar)");
        System.out.println("H12 Eletrotécnica e eletrônica de potência");
        System.out.println("{H0} nenhum\n");
        while(!entradaHabilidade(aluno, entrada));
        System.out.println("Quais são seus interesses?");
        System.out.println("I1 Robótica e automação");
        System.out.println("I2 Circuitos, chips e sinais");
        System.out.println("I3 Energia, veículos elétricos e indústria");
        System.out.println("I4 Inteligência artificial e visão computacional");
        System.out.println("I5 Acessibilidade, educação e meio ambiente");
        System.out.println("I6 Ação humanitária em comunidades");
        System.out.println("I7 Diversidade e inclusão na engenharia");
        System.out.println("I8 Eventos e vida de comunidade");
        System.out.println("I9 Bastidores e gestão do ramo");
        System.out.println("I10 Cenário internacional");
        System.out.println("{I0} nenhum\n");
        while(!entradaInteresses(aluno, entrada));
        System.out.println("Quais são suas atividades preferidas?");
        System.out.println("A1 Planejar e organizar eventos");
        System.out.println("A2 Construir protótipos e projetos");
        System.out.println("A3 Criar conteúdo e divulgar");
        System.out.println("A4 Acolher pessoas e engajar membros");
        System.out.println("A5 Registrar e documentar");
        System.out.println("A6 Buscar parcerias e contatos");
        System.out.println("A7 Controlar dinheiro e recursos");
        System.out.println("A8 Cuidar de espaço, materiais e logística");
        System.out.println("A9 Manter sites e sistemas");
        System.out.println("A10 Acompanhar prazos e entregas");
        System.out.println("{A0} nenhum\n");
        while(!entradaAtividades(aluno, entrada));
    }
    public static boolean entradaPerfil(Aluno aluno, Scanner entrada){
        String P1, P2;
            System.out.println("Escolha até 2 perfis, pelo menos 1");
            System.out.print("Primeiro perfil escolhido(PX): ");
            P1 = entrada.nextLine();
            if(P1.equals("P0")){
                System.out.println("Invalido, deve haver pelo menos 1 perfil");
                return false;
            }
            else if(P1.equals("P1") || P1.equals("P2") || P1.equals("P3") || P1.equals("P4") || P1.equals("P5") || P1.equals("P6"));
            else{
                System.out.println("Entrada Inválida");
                return false;
            }
            System.out.print("Segundo perfil escolhido(PX): ");
            P2 = entrada.nextLine();
            if(P2.equals(P1)){
                System.out.println("Invalido, escreva perfis diferentes");
                return false;
            }
            else if(P2.equals("P1") || P2.equals("P2") || P2.equals("P3") || P2.equals("P4") || P2.equals("P5") || P2.equals("P6"));
            else if(P2.equals("P0")) P2 = null;
            else{
                System.out.println("Entrada Inválida");
                return false;
            }
            
            aluno.setPerfil(new String[]{P1, P2});
            return true;
        } 
    public static boolean entradaHabilidade(Aluno aluno, Scanner entrada){
        String H1, H2, H3;
        System.out.println("Escolha até 3 Habilidades, pelo menos 1");
        System.out.print("Primeira habilidade escolhida(HX): ");
        H1 = entrada.nextLine();
        if(H1.equals("H0")){
                System.out.println("Invalido, deve haver pelo menos 1 habilidade");
                return false;
        }
        else if(H1.equals("H1") || H1.equals("H2") || H1.equals("H3") || H1.equals("H4") || 
                H1.equals("H5") || H1.equals("H6") || H1.equals("H7") || H1.equals("H8") || 
                H1.equals("H9") || H1.equals("H10") || H1.equals("H11") || H1.equals("H12"));
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        System.out.print("Segunda habilidade escolhido(HX): ");
        H2 = entrada.nextLine();
        if(H2.equals(H1)){
            System.out.println("Invalido, escreva habilidades diferentes");
            return false;
        }
        else if(H2.equals("H1") || H2.equals("H2") || H2.equals("H3") || H2.equals("H4") || 
                H2.equals("H5") || H2.equals("H6") || H2.equals("H7") || H2.equals("H8") || 
                H2.equals("H9") || H2.equals("H10") || H2.equals("H11") || H2.equals("H12"));
        else if(H2.equals("H0")) H2 = null;
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        System.out.print("Terceira habilidade escolhida(HX): ");
        H3 = entrada.nextLine();
        if(H3.equals(H1) || H3.equals(H2)){
            System.out.println("Invalido, escreva habilidades diferentes");
            return false;
        }
        else if(H3.equals("H1") || H3.equals("H2") || H3.equals("H3") || H3.equals("H4") || 
                H3.equals("H5") || H3.equals("H6") || H3.equals("H7") || H3.equals("H8") || 
                H3.equals("H9") || H3.equals("H10") || H3.equals("H11") || H3.equals("H12"));
        else if(H3.equals("H0")) H3 = null;
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        aluno.setHabilidades(new String[]{H1, H2, H3});
        return true;
    }
    public static boolean entradaInteresses(Aluno aluno, Scanner entrada){
        String I1, I2;
        System.out.println("Escolha até 2 interesses, pelo menos 1");
        System.out.print("Primeiro interesse escolhido(IX): ");
        I1 = entrada.nextLine();
        if(I1.equals("I0")){
            System.out.println("Invalido, deve haver pelo menos 1 interesse");
            return false;
        }
        else if(I1.equals("I1") || I1.equals("I2") || I1.equals("I3") || I1.equals("I4") || I1.equals("I5") || I1.equals("I6") || I1.equals("I7") || I1.equals("I8") || I1.equals("I9") || I1.equals("I10"));
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        System.out.print("Segundo interesse escolhido(IX): ");
        I2 = entrada.nextLine();
        if(I2.equals(I1)){
            System.out.println("Invalido, escreva interesses diferentes");
            return false;
        }
        else if(I1.equals("I1") || I1.equals("I2") || I1.equals("I3") || I1.equals("I4") || I1.equals("I5") || I1.equals("I6") || I1.equals("I7") || I1.equals("I8") || I1.equals("I9") || I1.equals("I10"));
        else if(I2.equals("I0")) I2 = null;
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        aluno.setInteresses(new String[]{I1, I2});
        return true;
    }
    public static boolean entradaAtividades(Aluno aluno, Scanner entrada){
        String A1, A2;
        System.out.println("Escolha até 2 atividades preferidas, pelo menos 1");
        System.out.print("Primeiro atividade escolhida(AX): ");
        A1 = entrada.nextLine();
        if(A1.equals("A0")){
            System.out.println("Invalido, deve haver pelo menos 1 atividade");
            return false;
        }
        else if(A1.equals("A1") || A1.equals("A2") || A1.equals("A3") || A1.equals("A4") || A1.equals("A5") || A1.equals("A6") || A1.equals("A7") || A1.equals("A8") || A1.equals("A9") || A1.equals("A10"));
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        System.out.print("Segunda atividade preferida escolhida(AX): ");
        A2 = entrada.nextLine();
        if(A2.equals(A1)){
            System.out.println("Invalido, escreva atividades diferentes");
            return false;
        }
        else if(A2.equals("A1") || A2.equals("A2") || A2.equals("A3") || A2.equals("A4") || A2.equals("A5") || A2.equals("A6") || A2.equals("A7") || A2.equals("A8") || A2.equals("A9") || A2.equals("A10"));
        else if(A2.equals("A0")) A2 = null;
        else{
            System.out.println("Entrada Inválida");
            return false;
        }
        aluno.setAtividadePreferida(new String[]{A1, A2});
        return true;
    }
    
    public static void calcularPontuacao(Aluno aluno, Assinatura[] areas){
        for(Assinatura area : areas){
            int total = 0, nP = 0, nH = 0, nI = 0, nA = 0;
            for(String pAss : area.getPerfil()){
                for(String pAlu : aluno.getPerfil()){
                    if(pAss.equals(pAlu)) nP++;
                }
            }
            for(String hAss : area.getHabilidades()){
                for(String hAlu : aluno.getHabilidades()){
                    if(hAss.equals(hAlu)) nH++;
                }
            }
            for(String iAss : area.getInteresses()){
                for(String iAlu : aluno.getInteresses()){
                    if(iAss.equals(iAlu)) nI++;
                }
            }
            for(String aAss : area.getAtividadesPreferidas()){
                for(String aAlu : aluno.getAtividadePreferida()){
                    if(aAss.equals(aAlu)) nA++;
                }
            }
            total = 3 * nI + 2 * nH + 2 * nA + nP;
            area.setNumInteresses(nI);
            area.setNumHabilidades(nH);
            area.setPontuacao(total);
        }
    }
    public static void calcularCompatibilidade(Assinatura[] areas){
        for(Assinatura area : areas){
            float compatibilidade = (float) 100.0f * area.getPontuacao() / area.getPontuacaoMax();
            area.setCompatibilidade(compatibilidade);
        }
    }
    public static Assinatura[] calcularPrioridades(Assinatura[] areas){
       
        Assinatura comissao1 = (areas[0].getCompatibilidade() >= areas[1].getCompatibilidade()) ? areas[0] : areas[1];
        Assinatura comissao2 = (areas[0].getCompatibilidade() < areas[1].getCompatibilidade()) ? areas[0] : areas[1];
        Assinatura grupo1 = (areas[11].getCompatibilidade() >= areas[12].getCompatibilidade()) ? areas[11] : areas[12];
        Assinatura grupo2 = (areas[11].getCompatibilidade() < areas[12].getCompatibilidade()) ? areas[11] : areas[12];
        for(int i = 2; i < areas.length; i++){
            if(areas[i].getTipo().equals("comissao")){
                if(areas[i].getCompatibilidade() > comissao1.getCompatibilidade()){
                    comissao2 = comissao1;
                    comissao1 = areas[i];
                }
                
                else if(areas[i].getCompatibilidade() > comissao2.getCompatibilidade()){
                    comissao2 = areas[i];
                }
            }
            if(i > 12 && (areas[i].getTipo().equals("grupos") || areas[i].getTipo().equals("capitulo"))){
                if(areas[i].getCompatibilidade() > grupo1.getCompatibilidade()){
                    grupo2 = grupo1;
                    grupo1 = areas[i];
                }
                else if(areas[i].getCompatibilidade() > grupo2.getCompatibilidade()){
                    grupo2 = areas[i];
                }
            }
        }
        Assinatura prioridades[] = {comissao1, comissao2, grupo1, grupo2};
        return prioridades;
    }
    public static void desempate(Assinatura[] prioridades){
        Assinatura comissao1 = prioridades[0], comissao2 = prioridades[1], aux;
        Assinatura grupo1 = prioridades[2], grupo2 = prioridades[3];
        if(comissao1.getCompatibilidade() == comissao2.getCompatibilidade()){
            if(comissao1.getNumInteresses() != comissao2.getNumInteresses()){
                if(comissao1.getNumInteresses() < comissao2.getNumInteresses()){
                    aux = comissao2;
                    comissao2 = comissao1;
                    comissao1 = aux;
                }
            }
            else{
                if(comissao1.getNumHabilidades() < comissao2.getNumHabilidades()){
                    aux = comissao2;
                    comissao2 = comissao1;
                    comissao1 = aux;
                }
            }
        }
        
        if(grupo1.getCompatibilidade() == grupo2.getCompatibilidade()){
            if(grupo1.getNumInteresses() != grupo2.getNumInteresses()){
                if(grupo1.getNumInteresses() < grupo2.getNumInteresses()){
                    aux = grupo2;
                    grupo2 = grupo1;
                    grupo1 = aux;
                }
            }
            else{
                if(grupo1.getNumHabilidades() < grupo2.getNumHabilidades()){
                    aux = grupo2;
                    grupo2 = grupo1;
                    grupo1 = aux;
                }
            }
        }
        prioridades[0] = comissao1;
        prioridades[1] = comissao2;
        prioridades[2] = grupo1;
        prioridades[3] = grupo2;
    }
    public static String explicacoes(String nome){
        String texto = switch(nome){
            case "Gestão de Projetos" -> """
                                         combina com quem é organizado e comunicativo, sabe gerir 
                                         projetos e tempo e gosta de acompanhar prazos e entregas.
                                         """;
            case "Atividades" -> """
                                 combina com quem é comunicativo e acolhedor, sabe gerir projetos 
                                 e explicar, se interessa por eventos e vida de comunidade e gosta 
                                 de planejar eventos.
                                 """;
            case "Comunicação" -> """
                                  combina com quem é criativo e expressivo, tem habilidade em design, 
                                  vídeo e escrita e gosta de criar conteúdo e divulgar o ramo.
                                  """;
            case "Gestão de Pessoas" -> """
                                        combina com quem é acolhedor e empático, se interessa por 
                                        inclusão na engenharia e gosta de acolher pessoas e engajar membros.
                                        """;
            case "Relações Internacionais" -> """
                                              combina com quem é articulador e bom em networking, tem inglês 
                                              e escrita e se interessa pelo cenário internacional e por buscar parcerias.
                                              """;
            case "Secretaria" -> """
                                 combina com quem é organizado e metódico, escreve bem e gosta de registrar e documentar.
                                 """;
            case "Finanças" -> """
                               combina com quem é organizado, tem habilidade com planilhas e orçamento e gosta de controlar 
                               recursos e buscar parcerias.
                               """;
            case "Infraestrutura" -> """
                                     combina com quem é organizado e focado, entende de eletrônica e hardware e gosta de 
                                     cuidar de espaço, materiais e logística.
                                     """;
            case "Webmaster" -> """
                                combina com quem é focado e independente, programa e desenvolve para web e gosta de 
                                manter sites e sistemas.
                                """;
            case "Proj. Técnicos: Sistemas Autônomos e IA" -> """
                                                              combina com quem é focado, programa e conhece robótica, 
                                                              automação e IA, se interessa por robótica e visão computacional 
                                                              e gosta de construir protótipos.
                                                              """;
            case "Proj. Técnicos: Tecnologias Assistivas, Educacionais e Socioambientais" -> """
                                                                                             combina com quem é acolhedor e 
                                                                                             criativo, une eletrônica, programação e didática, 
                                                                                             se interessa por acessibilidade, educação e meio 
                                                                                             ambiente e gosta de construir projetos.
                                                                                             """;
            case "WIE" -> """
                          combina com quem é acolhedor e comunicativo, se interessa por diversidade e inclusão na engenharia e gosta de acolher 
                          pessoas e organizar eventos. A indicação vem do interesse, não do gênero.
                          """;
            case "SIGHT" -> """
                            combina com quem é acolhedor, une eletrônica, programação e gestão e quer usar tecnologia em ações humanitárias em comunidades.
                            """;
            case "RAS" -> """
                          combina com quem é focado, domina robótica, programação e eletrônica, se interessa por robótica e automação e gosta de construir protótipos.
                          """;
            case "CASS" -> """
                          combina com quem é focado, tem eletrônica e processamento de sinais, se interessa por circuitos, chips e sinais e gosta de construir protótipos.
                          """;
            case "TEC/PELS/IAS" -> """
                                   combina com quem é focado, tem eletrotécnica e eletrônica de potência, se interessa por energia, veículos elétricos e indústria e 
                                   gosta de construir protótipos.
                                   """;
            default -> "Nenhum";
                    
        };
        return texto;
    } 
    public static void apresentarResultados(Assinatura[] prioridades, Aluno a){
        int i = 1;
        System.out.println("\nPrazer " + a.getNome());
        if(a.isEhMembro()){
            System.out.println("Sugerimos que você troque sua area atual por uma comissao e um grupo ou capitulo essas opções: ");
        }else{
            System.out.println("Sugerimos que você inicie em um comissão e em um grupo ou capitulo: ");
        }
        System.out.println("Veja as opções feitas para você!");
        for(Assinatura area : prioridades){
            System.out.println(i + "º Sugestão de " + area.getTipo() + ": " + area.getNome());
            float n = area.getCompatibilidade();
            System.out.println("Compatibilidade: " + n + "%");
            System.out.println("Explicação: " + explicacoes(area.getNome()));
            i++;
        }
    }
}
