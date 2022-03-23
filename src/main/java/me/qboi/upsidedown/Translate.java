package me.qboi.upsidedown;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Map;
import java.util.Objects;

@SuppressWarnings("ClassCanBeRecord")
public class Translate {
    private final File input;
    private final File output;

    public static void main(String[] args) throws IOException {
        File file = new File(args[0]);
        Gson gson = new Gson().newBuilder().create();
        JsonWriter writer = new JsonWriter(new FileWriter(args[1], StandardCharsets.UTF_8));
        writer.setIndent("  ");
        JsonObject root = gson.fromJson(new FileReader(file, StandardCharsets.UTF_8), JsonObject.class);
        JsonObject out = execute(root);
        gson.toJson(out, writer);
        writer.flush();
        writer.close();
    }

    public Translate(File input, File output) {
        this.input = input;
        this.output = output;
    }

    public void execute() throws IOException {
        Gson gson = new Gson().newBuilder().create();
        JsonWriter writer = new JsonWriter(new FileWriter(output, StandardCharsets.UTF_8));
        writer.setIndent("  ");
        JsonObject out = execute(gson.fromJson(new FileReader(input, StandardCharsets.UTF_8), JsonObject.class));
        gson.toJson(out, writer);
        writer.flush();
        writer.close();
    }

    public static JsonObject execute(JsonObject input) {
        JsonObject out = new JsonObject();
        for (Map.Entry<String, JsonElement> s : input.entrySet()) {
            String asString = s.getValue().getAsString();
            out.addProperty(s.getKey(), translate(s.getKey(), asString));
        }
        return out;
    }

    @SuppressWarnings("UnusedLabel")
    private static String translate(String key, String s) {
        if (Objects.equals(key, "language.code")) return s;

        StringBuilder sb = new StringBuilder();
        char[] charArray = s.toCharArray();
        mainLoop: for (int i = 0, charArrayLength = charArray.length; i < charArrayLength; i++) {
            char c = charArray[i];
            mainSwitch: switch (c) {
                case 'A' -> sb.insert(0, '\u2c6f');
                case 'B' -> sb.insert(0, '\u15fa');
                case 'C' -> sb.insert(0, '\u0186');
                case 'D' -> sb.insert(0, '\u15e1');
                case 'E' -> sb.insert(0, '\u018e');
                case 'F' -> sb.insert(0, '\u2132');
                case 'G' -> sb.insert(0, '\u2141');
                case 'H' -> sb.insert(0, 'H');
                case 'I' -> sb.insert(0, 'I');
                case 'J' -> sb.insert(0, '\u0550');
                case 'K' -> sb.insert(0, '\ua7b0');
                case 'L' -> sb.insert(0, '\ua780');
                case 'M' -> sb.insert(0, 'W');
                case 'N' -> sb.insert(0, 'N');
                case 'O' -> sb.insert(0, 'O');
                case 'P' -> sb.insert(0, '\u0500');
                case 'Q' -> sb.insert(0, '\ua779');
                case 'R' -> sb.insert(0, '\u1d1a');
                case 'S' -> sb.insert(0, 'S');
                case 'T' -> sb.insert(0, '\u27d8');
                case 'U' -> sb.insert(0, '\u2229');
                case 'V' -> sb.insert(0, '\u0245');
                case 'W' -> sb.insert(0, 'M');
                case 'X' -> sb.insert(0, 'X');
                case 'Y' -> sb.insert(0, '\u2144');
                case 'Z' -> sb.insert(0, 'Z');
                case 'a' -> sb.insert(0, '\u0250');
                case 'b' -> sb.insert(0, 'q');
                case 'c' -> sb.insert(0, '\u0254');
                case 'd' -> sb.insert(0, 'p');
                case 'e' -> sb.insert(0, '\u01dd');
                case 'f' -> sb.insert(0, '\u025f');
                case 'g' -> sb.insert(0, '\u1d77');
                case 'h' -> sb.insert(0, 'H');
                case 'i' -> sb.insert(0, '!');
                case 'j' -> sb.insert(0, '\u027e');
                case 'k' -> sb.insert(0, '\u029e');
                case 'l' -> sb.insert(0, 'l');
                case 'm' -> sb.insert(0, '\u026f');
                case 'n' -> sb.insert(0, 'u');
                case 'o' -> sb.insert(0, 'o');
                case 'p' -> sb.insert(0, 'd');
                case 'q' -> sb.insert(0, 'b');
                case 'r' -> sb.insert(0, '\u0279');
                case 's' -> sb.insert(0, 'S');
                case 't' -> sb.insert(0, '\u0287');
                case 'u' -> sb.insert(0, 'n');
                case 'v' -> sb.insert(0, '\u028c');
                case 'w' -> sb.insert(0, '\u028d');
                case 'x' -> sb.insert(0, 'x');
                case 'y' -> sb.insert(0, '\u028e');
                case 'z' -> sb.insert(0, 'z');
                case ':' -> sb.insert(0, ':');
                case ';' -> sb.insert(0, '\u2e35');
                case ' ' -> sb.insert(0, ' ');
                case '.' -> sb.insert(0, '\u02d9');
                case ',' -> sb.insert(0, '\'');
                case '\'' -> sb.insert(0, ',');
                case '*' -> sb.insert(0, '*');
                case '[' -> sb.insert(0, ']');
                case ']' -> sb.insert(0, '[');
                case '(' -> sb.insert(0, ')');
                case ')' -> sb.insert(0, '(');
                case '`' -> sb.insert(0, '`');
                case '|' -> sb.insert(0, '|');
                case '&' -> sb.insert(0, '\u214b');
                case '-' -> sb.insert(0, '-');
                case '=' -> sb.insert(0, '=');
                case '+' -> sb.insert(0, '+');
                case '/' -> sb.insert(0, '/');
                case '\\' -> sb.insert(0, '\\');
                case '1' -> sb.insert(0, '6');
                case '2' -> sb.insert(0, '8');
                case '3' -> sb.insert(0, '\u3125');
                case '4' -> sb.insert(0, '9');
                case '5' -> sb.insert(0, '\u03db');
                case '6' -> sb.insert(0, '\u07c8');
                case '7' -> sb.insert(0, '\u0190');
                case '8' -> sb.insert(0, '\u1614');
                case '9' -> sb.insert(0, '\u295d');
                case '0' -> sb.insert(0, '0');
                case '"' -> sb.insert(0, ",,");
                case '!' -> sb.insert(0, '\u00a1');
                case '?' -> sb.insert(0, '\u00bf');
                case '\n' -> sb.insert(0, '\n');
                case '<' -> sb.insert(0, '>');
                case '>' -> sb.insert(0, '<');
                case '#' -> sb.insert(0, '#');
                case '@' -> sb.insert(0, '@');
                case '^' -> sb.insert(0, '^');
                case '\u00AB' -> sb.insert(0, '\u00BB');
                case '\u00BB' -> sb.insert(0, '\u00AB');
                case '$' -> sb.insert(0, '$');
                case '\u2190' -> sb.insert(0, '\u2190');
                case '\u2191' -> sb.insert(0, '\u2191');
                case '\u2192' -> sb.insert(0, '\u2192');
                case '\u2193' -> sb.insert(0, '\u2193');
                case '_' -> sb.insert(0, '\u203E');
                case '\u00A7' -> {
                    sb.insert(0, '\u00A7');
                    System.out.println("WARNING: Need to update key: " + key);
                }
                case '%' -> {
                    i++;
                    if (i >= charArray.length) {
                        sb.insert(0, '%');
                        break;
                    }
                    charSwitch: switch (charArray[i]) {
                        case '%' -> sb.insert(0, "%%");
                        case 's' -> sb.insert(0, "%s");
                        case '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' -> {
                            StringBuilder s2 = new StringBuilder("%");
                            nameLoop: while (true) {
                                String s1 = "0123456789";
                                if (i >= charArray.length) {
                                    sb.append(s2);
                                }

                                if (s1.contains("" + charArray[i])) {
                                    s2.append(charArray[i]);
                                } else if (charArray[i] == '$') {
                                    s2.append(charArray[i]);
                                    i++;
                                    s2.append(charArray[i]);
                                    sb.append(s2);
                                    break charSwitch;
                                }

                                i++;
                            }
                        }
                    }
                }
                default -> throw new IllegalArgumentException("Illegal character: " + c + " at " + key);
            }
        }
        return sb.toString();
    }
}
