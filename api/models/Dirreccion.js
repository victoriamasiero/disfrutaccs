/**
 * Dirreccion.js
 *
 * @description :: TODO: Tabla que guarda la direccion y codigo postal de una actividad o sub-evento (actualmente no en uso)
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
 //connection: 'PostgresqlServer',
     attributes: {
    Codigo_postal: {
      type: 'integer',
      size:20,
      required: true
    },
    Direccion: {
      type: 'text'
    }
  }
};

