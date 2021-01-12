# SCDF


Producer , processor ,consumer are belongs to spring cloud data flow streams

source , transformation , sink are belongs to spring cloud task


For spring cloud data flow streams,

once u download all the required jars , maven clean install all the microserviecs of spring cloud data flow streams.

Start  all  spring cloud jars ,register apps with spring cloud and start stream.

1.Start dataflow server
2.Start skipper
3.optional start shell or u can register directly through UI.
app register --name producer --type source --uri maven://<artifact id>:<groud Id>:producer:0.0.1-SNAPSHOT.
app register --name consumer --type sink --uri maven://<artifact id>:<groud Id>:CONSUMER:0.0.1-SNAPSHOT.
app register --name processor --type processor --uri maven://<artifact id>:<groud Id>:processor:0.0.1-SNAPSHOT.


For spring cloud data flow task,

once u download all the required jars , maven clean install all the microserviecs of spring cloud data flow task.

Start  all  spring cloud jars ,register apps with spring cloud and start task.

register task applications through UI.
