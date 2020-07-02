Welcome this REST API has an will help person who can not calculate network addresses such as broadcast address, network address, how to divide the network into a subnet and perform determine if the addresses belong to the same network. 

The type of address ( addressType, maskType) is a "DECIMAL", "BINARY", "NUMBER_OF_ONES" (only for mask)

This api can solve four types of tasks:
####  Divide network to subnet:
> Request: .../divideNetwork?divideNetworkWithSubnet=2

Request param divideNetworkWithSubnet is between 1 and 131072 ( the limit is set by response size from 65537 to 131072 number of subnet a response has round 50MB)

```
 {
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.0.0.0",
    "maskType": "DECIMAL"
  }
```
> Response 200 Status OK
```
{
    "networkMask": {
        "binary": "11111111.10000000.00000000.00000000",
        "decimal": "255.128.0.0",
        "numberOfOnes": 9
    },
    "subnetAddresses": [
        {
            "networkAddress": {
                "binary": "10111111.00000000.00000000.00000000",
                "decimal": "191.0.0.0"
            },
            "broadcastAddress": {
                "binary": "10111111.01111111.11111111.11111111",
                "decimal": "191.127.255.255"
            },
            "firstHostAddress": {
                "binary": "10111111.00000000.00000000.00000001",
                "decimal": "191.0.0.1"
            },
            "lastHostAddress": {
                "binary": "10111111.01111111.11111111.11111110",
                "decimal": "191.127.255.254"
            }
        },
        {
            "address": {
                "binary": "10111111.10000000.00000000.00000000",
                "decimal": "191.128.0.0"
            },
            "broadcastAddress": {
                "binary": "10111111.11111111.11111111.11111111",
                "decimal": "191.255.255.255"
            },
            "firstHostAddress": {
                "binary": "10111111.10000000.00000000.00000001",
                "decimal": "191.128.0.1"
            },
            "lastHostAddress": {
                "binary": "10111111.11111111.11111111.11111110",
                "decimal": "191.255.255.254"
            }
        }
    ],
    "numberOfSubnet": 2,
    "numberOfHostsPerSubnet": 8388608
}
```
####  Divide network to subnet:

> Request: .../divideNetwork?divideNetwork=2

Request param divideNetworkWithSubnet is between 1 and 1073741823

```
{
  "address": "191.168.0.1",
  "addressType": "DECIMAL",
  "mask": "255.0.0.0",
  "maskType": "DECIMAL"
}
```
> Response 200 Status OK
```
{
    "networkMask": {
        "binary": "11111111.10000000.00000000.00000000",
        "decimal": "255.128.0.0",
        "numberOfOnes": 9
    },
    "subnetAddresses": null,
    "numberOfSubnet": 2,
    "numberOfHostsPerSubnet": 8388608
}
```
###  Calculate broadcast and network address:

> Request: .../calculateBroadcastAndNetworkAddress
```
{
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.255.0.0",
    "maskType": "DECIMAL"
}
```
> Response 200 Status OK
```
{
    "address": {
        "binary": "10111111.10101000.0.0",
        "decimal": "191.168.0.0"
    },
    "broadcastAddress": {
        "binary": "10111111.10101000.11111111.11111111",
        "decimal": "191.168.255.255"
    }
}
```
###  Calculate broadcast and network address:

This uri help when you to get to know could addresses are on the same network

> Request: .../calculateBroadcastAndNetworkAddress
```
[
  {
    "address": "191.168.0.1",
    "addressType": "DECIMAL",
    "mask": "255.255.0.0",
    "maskType": "DECIMAL"
  },
  {
    "address": "191.168.0.2",
    "addressType": "DECIMAL",
    "mask": "255.255.0.0",
    "maskType": "DECIMAL"
  }
]
```
> Response 200 Status OK
```
[
    {
        "network": {
            "networkAddress": {
                "binary": "10111111.10101000.0.0",
                "decimal": "191.168.0.0"
            },
            "networkMask": {
                "binary": "11111111.11111111.0.0",
                "decimal": "255.255.0.0",
                "numberOfOnes": 16
            },
            "broadcastAddress": {
                "binary": "10111111.10101000.11111111.11111111",
                "decimal": "191.168.255.255"
            }
        },
        "addresses": [
            {
                "binary": "10111111.10101000.0.1",
                "decimal": "191.168.0.1"
            },
            {
                "binary": "10111111.10101000.0.10",
                "decimal": "191.168.0.2"
            }
        ]
    }
]
```



