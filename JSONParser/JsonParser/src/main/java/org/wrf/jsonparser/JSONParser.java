package org.wrf.jsonparser;

import org.wrf.jsonparser.parser.Parser;
import org.wrf.jsonparser.tokenizer.CharReader;
import org.wrf.jsonparser.tokenizer.TokenList;
import org.wrf.jsonparser.tokenizer.Tokenizer;

import java.io.IOException;
import java.io.StringReader;

public class JSONParser {

    private Tokenizer tokenizer = new Tokenizer();

    private Parser parser = new Parser();

    public Object fromJSON(String json) throws IOException {
        CharReader charReader = new CharReader(new StringReader(json));
        TokenList tokens = tokenizer.tokenize(charReader);
        return parser.parse(tokens);
    }
}
