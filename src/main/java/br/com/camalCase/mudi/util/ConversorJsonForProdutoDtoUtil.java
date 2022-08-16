package br.com.camalCase.mudi.util;

import br.com.camalCase.mudi.dto.ProdutoDto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ConversorJsonForProdutoDtoUtil {

    public static List<ProdutoDto> extratorConteudo(String json){
        List<ProdutoDto> produtoDtos = new ArrayList<>();
        var parser = new JsonParserUtil();
        List<Map<String, String>> listProduto = parser.parse(json);
        System.out.println("Convertendo o Json");
        for (Map<String, String> mapProduto: listProduto) {
            ProdutoDto produto = new ProdutoDto();
            produto.setNome(mapProduto.get("nome"));
            produto.setUrlProduto(mapProduto.get("urlProduto"));
            produto.setDescricao(mapProduto.get("descricao"));
            produto.setUrlImagem(mapProduto.get("urlImagem"));
            produtoDtos.add(produto);
        }

        return produtoDtos;
    }
}
