const fs = require( 'fs' );
const csvParser = require( 'csv-parser' );
const mongoose = require( 'mongoose' );

mongoose.connect( 'mongodb://localhost:27017/practica2' )
    .then( () => console.log( 'Connected to MongoDB' ) )
    .catch( err => console.error( 'Connection error ', err ) );

const schema = new mongoose.Schema( {
    nombre: String,
    edad: Number,
    correo: String,
})

const Usuarios = mongoose.model( 'usuarios', schema );

function procesarCSV( filepath ) {
    return new Promise( ( resolve, reject) => {
        const results = [];


        fs.createReadStream( filepath )
            .pipe(csvParser())
            .on( 'data', ( data ) => 
                results.push({
                    nombre: data.nombre,
                    edad: parseInt(data.edad),
                    correo: data.correo,
                })
            )
            .on( 'end', async () => {
                console.log(results);
                
                try {
                    await Usuarios.insertMany( results );
                    console.log( 'CSV file successfully saved on DataBase' );
                    resolve();
                } catch (error) {
                    reject( error );
                }
            })
            .on( 'error', ( error ) => reject( error ));
            
    });
}

procesarCSV( 'assets/usuarios.csv' )
    .then( () => console.log( 'CSV file processed' ) )
    .catch( error => console.error( 'Error processing CSV file', error ) )
    .finally( () => mongoose.disconnect() );