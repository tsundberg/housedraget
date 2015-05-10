# Housedraget


## Production

[http://housedraget.herokuapp.com](http://housedraget.herokuapp.com) 

## Development

Build 
`mvn clean package`
  
Run  
`java -jar ./target/housedraget-1.0-SNAPSHOT.jar server configuration.yml`

Access the site on [http://localhost:8080](http://localhost:8080)

## Deployment

Deployment to production is done by pushing the changes to a git repository.

Clone a repository
`git@github.com:tsundberg/housedraget.git`

Add a remote repository  
`git remote add heroku git@heroku.com:housedraget.git`

Then push to the remote repo when it is time for a new deployment.  
`git push heroku`

