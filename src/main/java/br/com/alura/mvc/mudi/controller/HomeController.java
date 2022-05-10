package br.com.alura.mvc.mudi.controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import br.com.alura.mvc.mudi.model.Pedido;

@Controller
public class HomeController {

	@PersistenceContext
	private EntityManager entityManager;

	@GetMapping("/home")
	public String home(Model model) {
		
		Query query = entityManager.createQuery("select p from Pedido p", Pedido.class);
		List<Pedido> pedidos = query.getResultList();
		
		// PREENCHIMENTO MANUAL
//		  Pedido pedido = new Pedido();
//        pedido.setNomeProduto("Monitor LG 29' IPS, Ultra Wide");
//        pedido.setUrlImagem("https://images.kabum.com.br/produtos/fotos/157553/monitor-lg-led-29-ultrawide-ips-hdmi-displayport-hdr-com-vesa-e-alto-falante-amd-radeon-freesync-29wl500_1620660433_gg.jpg");
//        pedido.setUrlProduto("https://www.kabum.com.br/produto/157553/monitor-lg-29-ips-ultra-wide-full-hd-hdmi-vesa-ajuste-de-angulo-hdr-10-99-srgb-freesync-29wl500");
//        pedido.setDescricao("uma descrição qualquer para esse pedido");
//        
//        //USADOS PARA FINALIDADE DE TESTAR TODOS OS CAMPOS JÁ NESSA AULA
//        pedido.setValorNegociado(new BigDecimal("1299.90"));
//        pedido.setDataDaEntrega(LocalDate.of(2022, 5, 9));
//
//        List<Pedido> pedidos = Arrays.asList(pedido);
		model.addAttribute("pedidos", pedidos);

		return "home";
	}

}
