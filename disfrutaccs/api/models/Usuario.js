/**
 * Usuario.js
 *
 * @description :: TODO: You might write a short summary of how this model works and what it represents here.
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
  connection: 'mysql',
  attributes: {
    id_usuario: {
      type: 'integer',
       unique: true,
       autoIncrement: true
    },
    Nombre: {
      type: 'string',
      size: 45,
      notNull: true,
      required: true
    },
    Apellido: {
      type: 'string',
      size: 45,
      notNull: true
    },
    Fecha_de_nacimiento: {
      type: 'date',
      notNull:true
    },
    Fecha_de_consulta: {
      type: 'date'
    },
    Edad: {
      type: 'integer'
    },
    Indentificador: {
      type: 'boolean'
    },
    Correo: {
      type: 'email',
      email:true,
      unique: true,
      notNull:true
    },
    Alias: {
      type: 'string',
      size:45,
      unique: true
    },
    Sexo: {
      type: 'string',
      size:45,
    },
    Latitud: {
      type: 'float'
    },
    Longitud: {
      type: 'float'
    },
    Presupuesto: {
      type: 'float'
    },
      clave: {
      type: 'string',
      size:20,
      required: true
    },
    
    locales: {
      collection: 'Local',
      via: 'owner'
    },
    resenas: {
      collection: 'Resena',
      via: 'idusuario'
    }
  }
};

