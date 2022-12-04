package web;

import java.math.BigDecimal;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.annotation.PostConstruct;
import web.models.appservices.dtos.ShohinDto;
import web.models.domainobjects.VoDate;
import web.models.domainobjects.VoTime;
import web.models.domainobjects.entitys.ShohinEntity;
import web.models.domainobjects.interfacerepositorys.ShohinRepository;
import web.models.domainobjects.shohinvalueobjects.EditDateTime;
import web.models.domainobjects.shohinvalueobjects.Remarks;
import web.models.domainobjects.shohinvalueobjects.ShohinCode;
import web.models.domainobjects.shohinvalueobjects.ShohinName;
import web.models.domainobjects.shohinvalueobjects.UniqueId;

@SpringBootApplication
public class GradleGroovyTestApplication {

	@Autowired
	ShohinRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(GradleGroovyTestApplication.class, args);
	}

	@PostConstruct
	public void initialData() {
		var entity = new ShohinEntity(new UniqueId(UUID.randomUUID().toString()), 
				new ShohinCode(5600), new ShohinName("せとうちレモン"), 
				new EditDateTime(new VoDate(BigDecimal.valueOf(20211008)), new VoTime(BigDecimal.valueOf(203145))),
				new Remarks("瀬戸内レモンです"));
		repository.save(new ShohinDto(entity));
		entity = new ShohinEntity(new UniqueId(UUID.randomUUID().toString()), 
				new ShohinCode(6360), new ShohinName("リンゴジュース"), 
				new EditDateTime(new VoDate(BigDecimal.valueOf(20211206)), new VoTime(BigDecimal.valueOf(102533))),
				new Remarks("果汁100%の炭酸飲料です"));
		repository.save(new ShohinDto(entity));
		entity = new ShohinEntity(new UniqueId(UUID.randomUUID().toString()), 
				new ShohinCode(2580), new ShohinName("カフェオレ"), 
				new EditDateTime(new VoDate(BigDecimal.valueOf(20220321)), new VoTime(BigDecimal.valueOf(191106))),
				new Remarks("200ml増量です"));
		repository.save(new ShohinDto(entity));
		
		entity = new ShohinEntity(new UniqueId(UUID.randomUUID().toString()), 
				new ShohinCode(250), new ShohinName("さけおにぎり"), 
				new EditDateTime(new VoDate(BigDecimal.valueOf(20220416)), new VoTime(BigDecimal.valueOf(151615))),
				new Remarks("北海道産さけ使用"));
		repository.save(new ShohinDto(entity));
		entity = new ShohinEntity(new UniqueId(UUID.randomUUID().toString()), 
				new ShohinCode(260), new ShohinName("うめおにぎり"), 
				new EditDateTime(new VoDate(BigDecimal.valueOf(20220513)), new VoTime(BigDecimal.valueOf(111506))),
				new Remarks("none"));
		repository.save(new ShohinDto(entity));
		entity = new ShohinEntity(new UniqueId(UUID.randomUUID().toString()), 
				new ShohinCode(260), new ShohinName("カニクリームコロッケ"), 
				new EditDateTime(new VoDate(BigDecimal.valueOf(20220529)), new VoTime(BigDecimal.valueOf(141521))),
				new Remarks("３個入りです"));
		repository.save(new ShohinDto(entity));
		repository.flush();
	}
}
