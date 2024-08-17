import com.project.service.ErpPessoaFornecedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

public class ErpPessoafornecedorControler {

    private final ErpPessoaFornecedorService service;

    // Injeção do serviço via construtor
    @Autowired
    public ErpPessoaFornecedorControler(ErpPessoaFornecedorService service) {
        this.service = service;
    }

    @GetMapping("/pessoafornecedor")
    public String listar(@RequestParam(required = false) String active,
                         @RequestParam(required = false) String cnpj,
                         @RequestParam(required = false) String razaoSocial,
                         @RequestParam(required = false) String dataLancamento) {
        return service.listar(active, cnpj, razaoSocial, dataLancamento);
    }
}
