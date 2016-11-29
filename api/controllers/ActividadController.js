

module.exports = {

    registrar: function(req,res){

		Usuario.findOne(req.param('owner'), function encontraradmin (err, us) {
        if(err) {return next(err);}
        console.log(us)
        res.view({Usuario:us});// ('/Local/mostrar/'+ Local.id);

     });
	},


    create: function(req,res,next){
        
        Actividad.create(req.params.all(), function Actividadcreada (err, Actividad) {
        if(err) {return next(err);}
     });

     Dir_actividad.create(req.param.all), function Dircreada (err, Dir_actividad){
         if(err){return next(err);}
     }
     res.redirect ('/actividad/mostrar/'+ Actividad.id);
    
    },

    mostrar: function(req,res,next){

    Actividad.findOne({id: req.param('id')}).exec(function(err,resultado){

    if (err) {return res.serverError(err);}

             Resena.query('Select Alias, b.Comentario, b.id from Usuario inner join Resena b on Usuario.id = b.idusuario where b.idactividad='+resultado.id+';' , function(err, results) {
             if (err) return res.serverError(err);
             var string=JSON.stringify(results);
             var json =  JSON.parse(string);


             resultado.Resena = json;
             console.log(resultado.Resena);
             res.view({Actividad: resultado});
             } );


/*


            Resena.find({idactividad:resultado.id}).exec(function(err,resultadoresena){
            

            if(resultadoresena === undefined){
            return res.view({Actividad:resultado}); }
            
            else{

                


                resultado.Resena = resultadoresena;
                res.view({Actividad:resultado});}

              
         });*/
        
     });
    },

    buscar: function(req,res,next){

            var letras = '%'+req.param('Nombre')+'%';
            
    
            Actividad.query('select * from actividad where (local = true AND nombre like \''+letras+'\');' , function(err, locales) {
             
             if (err) return res.serverError(err);
             var string =JSON.stringify(locales);
             var json =  JSON.parse(string);
             var aux = json;
             
             console.log(aux);

             Actividad.query('select * from actividad where (local = false AND nombre like \''+letras+'\');'
            , function(err, eventos) {
             if (err) return res.serverError(err);
             var string=JSON.stringify(eventos);
             var json2 =  JSON.parse(string);
             aux.evento = json2;

             console.log(aux.evento);
             res.view({Actividad: aux});
             });
             
             } );

/*

    Actividad.find({Nombre:{'contains':req.param('Nombre')} }).exec(function(err,resultado){



    if (err) {return res.serverError(err);}

    if(resultado !== undefined) {



    console.log(resultado);
    res.view({Actividad:resultado});
    }
    if(resultado === undefined){
    return res.notFound('Could not find, sorry.');}

     });    */
    } ,

    consultar: function(req,res){

            Actividad.query('select * from actividad;'
            , function(err, actividades) {




             if (err) return res.serverError(err);
             var string=JSON.stringify(actividades);
             var json =  JSON.parse(string);
             var aux = json;

             Actividad.query('select actividad.id as id,actividad.nombre as nombre, count(resena.id) as r, actividad.Tipodelocal as tipo from actividad inner join resena on actividad.id = resena.idactividad where actividad.local = false group by nombre order by 4, 3 desc;',function(err,masresenas){
             var string2 =JSON.stringify(masresenas);
             var json2 =  JSON.parse(string2);
             var aux2 = json2;
             console.log(aux);
             console.log(aux2);

             res.view({Actividad: aux, mejores: aux2});

             });



             });
        
    },

    misactividades: function(req,res,next){
        var id = req.param('id');
        
        if(id !== undefined){ Actividad.find({owner:id}).exec(function(err,resultado){
    
         if (err) {return res.serverError(err);}

         if(resultado !== undefined) {
             console.log(resultado);
             res.view({Actividad:resultado});
         }
         if(resultado === undefined){return res.notFound('No hay locales con ese nombre :c ');}

            });  
        };

    },

    editar: function(req,res,next){

    Actividad.findOne({id: req.param('id')}).exec(function(err,resultado){
    if (err) {return res.serverError(err);}
    
    if(resultado !== undefined) {
    res.view({Actividad:resultado});
    }
    if(resultado === undefined){
    return res.notFound('Errooor');}
        
     });
    },

    actualizar: function(req, res,next){

        Actividad.update(req.param('id'), req.params.all() , function Actividadactualizado (err) {
        if(err) {return res.redirect('/Actividad/editar/'+req.param('id'));}

        res.redirect ('/Actividad/mostrar/'+ req.param('id'));
     });
    }

	
};

