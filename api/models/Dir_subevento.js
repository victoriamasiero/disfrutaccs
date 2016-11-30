/**
 * Dir_subevento.js
 *
 * @description :: TODO: Tabla de union entre id del sub-evento y dirrecion del mismo (actualmente no en uso)
 * @docs        :: http://sailsjs.org/documentation/concepts/models-and-orm/models
 */

module.exports = {
 //connection: 'PostgresqlServer',
   attributes: {
    autoPK: false,
    id_subevento: {
    type: 'integer'
    },
    id_direccion: {
    type: 'integer'
    }
  }
};

