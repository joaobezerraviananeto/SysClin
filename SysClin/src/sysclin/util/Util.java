package sysclin.util;

import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.AbstractAction;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class Util {

    JRootPane meurootpane;

    public static String getVersao() {
        return "1.5";
    }

    /**
     * Realiza a validação do CPF.
     *
     * @param strCpf
     * @return true se o CPF é válido e false se não é válido
     */
    public static boolean isIntegerValid(String numero){
        try {
            Integer.parseInt(numero);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    public static boolean CPF(String strCpf) {
        if (strCpf.equals("")) {
            return false;
        }

        if (strCpf.equals("00000000000") || strCpf.equals("11111111111")
                || strCpf.equals("22222222222") || strCpf.equals("33333333333")
                || strCpf.equals("44444444444") || strCpf.equals("55555555555")
                || strCpf.equals("66666666666") || strCpf.equals("77777777777")
                || strCpf.equals("88888888888") || strCpf.equals("99999999999")
                || (strCpf.length() != 11)) {
            return (false);
        }

        int d1, d2;
        int digito1, digito2, resto;
        int digitoCPF;
        String nDigResult;

        d1 = d2 = 0;
        digito1 = digito2 = resto = 0;

        for (int nCount = 1; nCount < strCpf.length() - 1; nCount++) {
            digitoCPF = Integer.parseInt(strCpf.substring(nCount - 1, nCount));

            //multiplique a ultima casa por 2 a seguinte por 3 a seguinte por 4 e assim por diante.  
            d1 = d1 + (11 - nCount) * digitoCPF;

            //para o segundo digito repita o procedimento incluindo o primeiro digito calculado no passo anterior.  
            d2 = d2 + (12 - nCount) * digitoCPF;
        }

        //Primeiro resto da divisão por 11.  
        resto = (d1 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {
            digito1 = 0;
        } else {
            digito1 = 11 - resto;
        }

        d2 += 2 * digito1;

        //Segundo resto da divisão por 11.  
        resto = (d2 % 11);

        //Se o resultado for 0 ou 1 o digito é 0 caso contrário o digito é 11 menos o resultado anterior.  
        if (resto < 2) {
            digito2 = 0;
        } else {
            digito2 = 11 - resto;
        }
        //Digito verificador do CPF que está sendo validado.  
        String nDigVerific = strCpf.substring(strCpf.length() - 2, strCpf.length());

        //Concatenando o primeiro resto com o segundo.  
        nDigResult = String.valueOf(digito1) + String.valueOf(digito2);

        //comparar o digito verificador do cpf com o primeiro resto + o segundo resto.  
        return nDigVerific.equals(nDigResult);
    }

    /* @MD5 Método de Encriptação da Senha em um HASH Hexadecimal */

    public static String md5(String senha) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            BigInteger hash = new BigInteger(1, md.digest(senha.getBytes()));
            return ((String) hash.toString(16));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static boolean chkVazios(String... campos) {
        for (String chk : campos) {
            if (chk.isEmpty() || chk.equals("-----") || chk.equals("  /  /    ") || chk.equals("  .   .   /    -  ")
                    || chk.equals("(  )     -    ") || chk.equals(".   .   -")) {
                JOptionPane.showMessageDialog(null, "Existem campos obrigatórios que não foram preenchidos!");
                return false;
            }
        }
        return true;
    }
    
    public static boolean chkVazio(String campo) {
        
            if (campo.isEmpty() || campo.equals("-----") || campo.equals("  /  /    ") || campo.equals("  .   .   /    -  ")
                    || campo.equals("(  )     -    ") || campo.equals(".   .   -")){
                return false;
        }
        return true;
    }
    
    public static long sanitizeLong(String texto){
     if(!chkVazio(texto)){
       return 0;
     }else{
       return Long.parseLong(texto);
     }
    }
    
    public static int sanitizeInt(String texto){
     if(!chkVazio(texto)){
       return 0;
     }else{
       return Integer.parseInt(texto);
     }
    }

    public static boolean chkCaracteres(String... caracteres) {
        Pattern regex = Pattern.compile("\\W");
        Matcher comparador;

        /* Verifica se algum caractere especial 
         * está contido dentro de um dos campos */
        for (int x = 0; x < caracteres.length; x++) {
            if (((comparador) = regex.matcher(caracteres[x])).find()) {
                JOptionPane.showMessageDialog(null,
                        "Não é permitido o uso de caracteres especiais!", "Caracteres Inválidos",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        }
        return true;
    }

    /**
     * @Flag - decimalFormat()
     * @param opt int VarArg
     * @Values..
     * @return -> 0000000 [ if opt(null) or !opt ]
     * @return -> 0000 [ if opt(1) ]
     */
    public static DecimalFormat decimalFormat(int... opt) {
        return new DecimalFormat(((opt.length <= 0) ? "0000000" : "0000"));
    }

    static public boolean dataValida(String data) {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        df.setLenient(false); // aqui o pulo do gato  
        try {
            df.parse(data);
            // data válida
            return true;
        } catch (ParseException ex) {
            // data inválida  
            return false;
        }
    }

    public static int diferencaData(Date dia1, Date dia2) {

        //DateFormat fmt = new SimpleDateFormat("dd/MM/yyyy");
        Date data3 = null;
        Date data4 = null;
        long m1 = 0;
        long m2 = 0;
        try {
            data3 = (Date) dia1;
            data4 = (Date) dia2;
        } catch (Exception e) {
        }
        Calendar data1 = new GregorianCalendar();
        data1.setTime(data3);
        Calendar data2 = new GregorianCalendar();
        data2.setTime(data4);
        m1 = data1.getTimeInMillis();
        m2 = data2.getTimeInMillis();
        return (int) ((m2 - m1) / (24 * 60 * 60 * 1000));
    }

    public static void setAcessibilidade(final JFrame tela) {
        Util utilidades = new Util();
        utilidades.meurootpane = tela.getRootPane();
        utilidades.meurootpane.getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), "ESCAPE");
        utilidades.meurootpane.getRootPane().getActionMap().put("ESCAPE", new AbstractAction("ESCAPE") {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Deseja sair do formulário?", "Sair", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    tela.setVisible(false);
                }
            }
        });
    }

    public static boolean chkSize(List lista, String type) {
        if (lista.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Não foram encontrados registros para: " + type);
            return false;
        } else {
            return true;
        }
    }

    public static void setIcon(Class classe, JFrame jframe) {
        jframe.setIconImage(Toolkit.getDefaultToolkit().getImage(classe.getResource("/fvsosp/imagens/bicoaguia.png")));
    }

    static public boolean validaCNPJ(String str_cnpj) {
        int soma = 0, aux, dig;
        String cnpj_calc = str_cnpj.substring(0, 12);

        if (str_cnpj.length() != 14) {
            return false;
        }

        char[] chr_cnpj = str_cnpj.toCharArray();

        /* Primeira parte */
        for (int i = 0; i < 4; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (6 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 4] - 48 >= 0 && chr_cnpj[i + 4] - 48 <= 9) {
                soma += (chr_cnpj[i + 4] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);

        cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);

        /* Segunda parte */
        soma = 0;
        for (int i = 0; i < 5; i++) {
            if (chr_cnpj[i] - 48 >= 0 && chr_cnpj[i] - 48 <= 9) {
                soma += (chr_cnpj[i] - 48) * (7 - (i + 1));
            }
        }
        for (int i = 0; i < 8; i++) {
            if (chr_cnpj[i + 5] - 48 >= 0 && chr_cnpj[i + 5] - 48 <= 9) {
                soma += (chr_cnpj[i + 5] - 48) * (10 - (i + 1));
            }
        }
        dig = 11 - (soma % 11);
        cnpj_calc += (dig == 10 || dig == 11)
                ? "0" : Integer.toString(dig);

        return str_cnpj.equals(cnpj_calc);
    }

    public static String formatarCPF(String cpf) {
        String novoCpf = "";

        for (int i = 0; i < cpf.length(); i++) {
            if (!cpf.substring(i, i + 1).equals("-") && !cpf.substring(i, i + 1).equals(".")) {
                novoCpf += cpf.substring(i, i + 1);
            }
        }
        return novoCpf;
    }

    public static Date formatData(String data) {
        try {
            DateFormat formatter = new SimpleDateFormat("MM/dd/yy");
            return (Date) formatter.parse(data);
        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao formatar a data");
            return null;
        }
    }
    
    
    public static void limparCamposGenerico(JDialog Frame) {
        //limpa os campos     
        for (int i = 0; i < Frame.getContentPane().getComponentCount(); i++) {
            //varre todos os componentes     
            Component c = Frame.getContentPane().getComponent(i);
            if (c instanceof JComboBox) {
                JComboBox field = (JComboBox) c;
                field.setSelectedItem("-----");
            }else if (c instanceof JTextField) {
                JTextField field = (JTextField) c;
                field.setText("");
            }else if (c instanceof JRadioButton) {
                JRadioButton field = (JRadioButton) c;
                field.setSelected(false);
            }else if (c instanceof JCheckBox) {
                JCheckBox field = (JCheckBox) c;
                field.setSelected(false);
            }
            
        }
    }
}
