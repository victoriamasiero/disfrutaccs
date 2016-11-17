/**
 * TareaController
 *
 * @description :: Server-side logic for managing tareas
 * @help        :: See http://sailsjs.org/#!/documentation/concepts/Controllers
 */

module.exports = {
	

consultar: function(req,res,next){



	if(req.param('flag') == 2){

		var flag = 2;
		Tarea.query('select concat(nombre,\'  \',apellido) as Empleado,  RentasTotales, GananciaTotal from (select s.first_name as nombre, s.last_name as apellido,count(p.rental_id) as RentasTotales,  sum(p.amount) as GananciaTotal from staff s inner join payment p on s.staff_id = p.staff_id group by s.staff_id order by RentasTotales desc limit 1) a;',
		function(err,resultado){
			
		if(err) {return next(err);}
		res.view('tarea/consultar', {id: flag , tabla: resultado});

	});
	}

	if(req.param('flag') == 3){
		
		var flag = 3;
		Tarea.query('select f.title as PeliculasNuncaRentadas from film f left outer join inventory i on f.film_id = i.film_id left outer join rental r on r.inventory_id = i.inventory_id where (r.inventory_id IS NULL) group by f.title;',
		function(err,resultado){
			
		if(err) {return next(err);}
		
		res.view('tarea/consultar', {id: flag , tabla: resultado});

	});
	}
  
	if(req.param('flag') == 1){

	var flag = 1;
		
		Tarea.query('Select Pelicula, concat(Nombre,\' \',Apellido) as NombreActor, Categoria, Ingles, '+
		'Descripcion, Ciudades'+
		' from (select f.title as Pelicula, a.first_name as Nombre, a.last_name as Apellido, '+
		' category.name as Categoria,'+
		' IF (`language`.name = \'English\', \'true\' , \'false\') as Ingles,'+
		' f.description as Descripcion, count(c.city_id) as Ciudades'+
		' from film f inner join film_actor fa on f.film_id = fa.film_id'+
		' inner join actor a on a.actor_id = fa.actor_id '+
		' inner join film_category fc on f.film_id = fc.film_id'+
		' inner join category on fc.category_id = category.category_id'+
		' inner join `language` on f.language_id = `language`.language_id'+
		' inner join inventory i on i.film_id = f.film_id'+
		' inner join store on store.store_id = i.store_id'+
		' inner join address ad on ad.address_id = store.address_id'+
		' inner join city c on c.city_id = ad.city_id'+
		' group by f.film_id'+
		' HAVING ((Categoria = \'Family\' or Categoria = \'Documentary\')'+
		' and (Nombre = \'ED\' or Nombre = \'GOLDIE\' or Nombre = \'FRED\')))a;',
		function(err,resultado){
			
		if(err) {return next(err);}
		
		res.view('tarea/consultar', {id: flag , tabla: resultado});
		});

}



	if(req.param('flag') == 4){

	var flag = 4;
		Tarea.query('select distinct concat(d.first_name,\' \', d.last_name) as Cliente'+
		' from( select DATEDIFF(b.return_date,b.rental_date) as dif, c.first_name, c.last_name'+
		' from payment a'+
		' inner join rental b on a.rental_id = b.rental_id'+
		' inner join customer c on b.customer_id = c.customer_id'+
		' having dif > 3'+
		' order by first_name) d;',
		function(err,resultado){
			
		if(err) {return next(err);}
		
		res.view('tarea/consultar', {id: flag , tabla: resultado});
		});

	}
	

}






};

